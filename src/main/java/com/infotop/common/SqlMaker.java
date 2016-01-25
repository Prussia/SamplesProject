package com.infotop.common;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.engine.transaction.jta.platform.internal.SynchronizationRegistryBasedSynchronizationStrategy;

/**
 * 根据实体类生成相应的SQL文件
 * 
 * 2015年11月8日下午2:37:27
 */
public class SqlMaker {

	public static void main(String[] args) {
		String[] classPaths = {"com.infotop.app.linkman.Linkman"};
		
		for(String classPath : classPaths){
			classPath = classPath.replace(".", "/");
			String relativelyPath=System.getProperty("user.dir");
			relativelyPath = relativelyPath.replace("\\", "/");
			String sourcePath = relativelyPath + "/src/main/java/";
			String destPath = relativelyPath + "/src/resources/sql/mysql/";
			File file = new File(sourcePath + classPath+".java");  
			File dest = new File(destPath + "/temp.sql");  
			try {  
			      BufferedReader reader = new BufferedReader(new FileReader(file));  
			      if(!dest.exists()){
			    	  dest.createNewFile();
			      }
			      BufferedWriter writer  = new BufferedWriter(new FileWriter(dest));  
			      String line = reader.readLine();  
			      
			      String tableName = "";
			      String columnType = "";
			      String columnName = "";
			      String columnComment = "";
			      
			      String writeContent = "";
			      
			      writeContent = "create table ";
			      
			      boolean findTableNameFlag = false;
			      while(line!=null){  
			    	  if(!findTableNameFlag){
				    	  Pattern pattern = Pattern.compile("@Table*");
				    	  Matcher matcher = pattern.matcher(line);
				    	  if(matcher.find()){
				    		  int begin = line.indexOf("\"");
				    		  int end = line.indexOf("\"", begin+1);
				    		  tableName = line.substring(begin+1, end);
				    		  
				    		  //开篇以及id
				    		  writeContent += tableName + "(\n";
				    		  writeContent += "\t\t id int(10) not null  auto_increment,\n";
				    		  findTableNameFlag = true;
				    	  }
			    	  }
			    	 
			    	  
			    	  //根据空格拆分
			    	  line = line.trim();
			    	  String[] chars = line.split("\\s+");
			    	  //以private开始的才进行处理，字符集合第二个就是字段类型，第三个就是“字段名称+；”，之后的就是备注
			    	  if(chars.length>2){
				    	  if("private".equals(chars[0].trim())){
				    		  
				    		  //长度先取默认值吧
				    		  switch(chars[1]){
				    		  case "int":
				    			  columnType = "int";
				    			  break;
				    		  case "String":
				    			  columnType = "varchar(100)";
				    			  break;
				    		  case "long":
				    			  columnType = "bigint(10)";
				    			  break;
				    		  default:
				    			  columnType = "varchar(100)";
				    		  }
				    		  
				    		  columnName = chars[2].replace(";", "");
				    		  
				    		  //表示有注释，先不对里面的 ；//等进行处理
				    		  if(chars.length>3){
				    			  for(int i = 3; i<chars.length;i++){
				    				  columnComment += chars[i];
				    			  }
				    			  columnComment.replace("//", "");
				    		  }
				    		  
				    		  writeContent += "\t\t " + columnName + " " + columnType + " null comment '" + columnComment + "',\n";
				    	  } 
			    	  
				    	  writer.write(writeContent);
				    	  
				    	  columnType = "";
				    	  columnName = "";
				    	  columnComment = "";
				    	  writeContent = "";
			    	  
			    	  }
			    	  
			          line = reader.readLine();  
			      }  
			      
			      //结尾
			      writeContent += " PRIMARY KEY (`id`)\n";
			      writeContent += ") ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;\n ";
			      writer.write(writeContent);
			      
			      writer.flush();  
			      reader.close();  
			      writer.close();  
			      
			      dest.renameTo(new File("D:/"+tableName+".sql"));
		     
		 
		      
			  } catch (FileNotFoundException e) {  
			      e.printStackTrace();  
			  } catch (IOException e) {  
			      e.printStackTrace();  
			  }  
		}
		System.out.println("finish!");
	}

	public static String[] types ={"String", "int", "long"};
	
}
