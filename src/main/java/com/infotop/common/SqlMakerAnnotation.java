package com.infotop.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;

import javax.persistence.Table;

public class SqlMakerAnnotation {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		String[] classPaths = {"com.infotop.app.linkman.Linkman"};
		createSql(classPaths);
	}

	private static boolean createSql(String[] classPaths) throws ClassNotFoundException, IOException {
		boolean finishFlag = true;
		String fieldName = "";
		String fieldType = "";
		StringBuffer sb = new StringBuffer();
		for(String classPath : classPaths){
			//反射获取类
			Class cl = Class.forName(classPath);
			//处理表名
			Table table = (Table)cl.getAnnotation(Table.class);
			if(table == null){
				System.out.println("没有定义@Table注解，无法解析表名");
				return false;
			}
			
			//生成sql文件
			String relativelyPath=System.getProperty("user.dir");
			relativelyPath = relativelyPath.replace("\\", "/");
			String destPath = relativelyPath + "/src/resources/sql/mysql/";
			File dest = new File(destPath + "/" + table.name() + ".sql");  
			if(!dest.exists()){
				dest.createNewFile();
			}
			
		    BufferedWriter writer  = new BufferedWriter(new FileWriter(dest));  

		    sb.append("create table ").append(table.name()).append(" (\n").append(" ");
			
			//获取父类字段
			Field[] fields = cl.getFields();
			for(Field field : fields){
				//大小写转换，大写字母转换为 下划线+小写字母
				fieldName = covertFieldNameToColumnName(field.getName());
				fieldType = covertFieldTypeToColumnType(field.getType().getName());
				sb.append("\t").append(fieldName).append(" ").append(fieldType).append(", \n");
			}
			//获取本类字段
			Field[] fields2 = cl.getDeclaredFields();
			for(Field field : fields2){
				//大小写转换，大写字母转换为 下划线+小写字母
				fieldName = covertFieldNameToColumnName(field.getName());
				fieldType = covertFieldTypeToColumnType(field.getType().getName());
				sb.append("\t").append(fieldName).append(" ").append(fieldType).append(", \n");
			}
			
			
			sb.append("primary key(id)").append(" \n");
			sb.append(") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8; ");
			writer.write(sb.toString());
			writer.flush();
			writer.close();
			
		}
		
		System.out.println("finish!");
		return finishFlag;
	}
	
	/**
	 * 大写字母转换为 下划线+小写字母
	 * @param fieldName
	 * @return
	 */
	public static String covertFieldNameToColumnName(String fieldName){
		String columnName = "";
		char[] c = fieldName.toCharArray();
		for(int i=0;i<c.length;i++){
			if(c[i]>='A'&&c[i]<='Z'){
				c[i] += 32;
				columnName += "_" + c[i];
			}else{
				columnName += c[i];
			}
		}
		
		return columnName;
	}
	
	/**
	 * 字段类型转换为列类型
	 * @param fieldType
	 * @return
	 */
	public static String covertFieldTypeToColumnType(String fieldType){
		fieldType = fieldType.toLowerCase();
		String[] fieldTypes = fieldType.split("\\.");
		if(fieldTypes.length>1){
			fieldType = fieldTypes[fieldTypes.length-1];
		}else{
			fieldType = fieldTypes[0];
		}
		String columnType = "varchar(100) ";
		switch(fieldType){
		case "long":
			columnType = "bigint(10) ";
			break;
		case "string":
			columnType = "varchar(100) ";
			break;
		case "int":
			columnType = "int ";
			break;
		case "boolean":
			columnType = "varchar(10) ";
			break;
		}
		
		return columnType;
	}

}
