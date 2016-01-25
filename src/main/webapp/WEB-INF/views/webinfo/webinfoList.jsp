<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div data-options="fit:true" class="easyui-panel">
	<div class="easyui-layout" data-options="fit:true">
		<div
			data-options="region:'north',border:false,title:'查询条件',iconCls:'icon-find'"
			style="height: 65px;overflow: hidden;">
			<form id="webinfo_list_searchForm" method="post"
				style="width:100%;overflow:hidden;">
				<table class="search_table" style="width: 100%;">
					<tr>
   						<th>标题</th>
						<td><input type="text" name="search_LIKE_title"
							value="${ param.search_LIKE_title}"
							id="search_EQ_title" /></td>   						
						<th><spring:message code="webinfo_issuer" /></th>
						<td><input type="text" name="search_EQ_issuer"
							value="${ param.search_EQ_issuer}"
							id="search_EQ_issuer" /></td>                    						<th style="width:20%;">&nbsp;<a href="javascript:void(0);"
							id="webinfo_list_searchBtn">查询</a>&nbsp;<a
							href="javascript:void(0);" id="webinfo_list_clearBtn">清空</a></th>
					</tr>
				</table>
			</form>
		</div>
		<div data-options="region:'center',border:false">
			<table id="webinfo_list_dg" style="display: none;"></table>
		</div>
		<div id="webinfo_list_toolbar" style="display: none;">
				<a href="javascript:updateForm(webinfo_list_create_url,'webinfo_form_inputForm',webinfo_list_datagrid,{title:'新增信息'},1400, 600);" class="easyui-linkbutton" data-options="iconCls:'icon-add',plain:false">添加</a> 			
		  	  <a href="javascript:deleteBatch(webinfo_list_delete_url,webinfo_list_datagrid);" class="easyui-linkbutton"  data-options="iconCls:'icon-remove',plain:false">删除</a>
			</div> 
	</div>
</div>
<script type="text/javascript">
	//列表DataGrid
	var webinfo_list_datagrid;
	//列表DataGrid ID
	var webinfo_list_datagrid_id = 'webinfo_list_dg';
	//列表查询表单ID
	var webinfo_list_searchform_id = 'webinfo_list_searchForm';
	//列表toolbar ID
	var webinfo_list_toolbar_id = 'webinfo_list_toolbar';
	//操作链接
	var webinfo_list_create_url =  '${ctx}/webinfo/create';
	var webinfo_list_update_url =  '${ctx}/webinfo/update/';
	var webinfo_list_delete_url =  '${ctx}/webinfo/delete';
	var webinfo_list_view_url =  '${ctx}/webinfo/view/';
	var webinfo_list_datagrid_load_url = '${ctx}/webinfo/findList';
	
	//定义相关的操作按钮
	function webinfo_list_actionFormatter(value,row,index){
		var str = '';	
		str += formatString(
				'<img onclick="updateForm(\'{0}\',\'webinfo_form_inputForm\',webinfo_list_datagrid,{title:\'编辑信息\'},1000, 600);" src="{1}" title="编辑"/>',
				webinfo_list_update_url + row.id,
				'${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/application_form_edit.png');
		str += '&nbsp;';
		str += formatString('<img onclick="deleteOne(\'{0}\',\'{1}\',webinfo_list_datagrid);" src="{2}" title="删除"/>',
		                    row.id,webinfo_list_delete_url,'${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/application_form_delete.png');
		str += '&nbsp;';
		str += formatString(
				'<img onclick="view(\'{0}\',1000, 600);" src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/view.png" title="查看"/>',
				webinfo_list_view_url + row.id);
		str += '&nbsp;';
		return str;
	}
	
	//DataGrid字段设置
	var webinfo_list_datagrid_columns = [ [
	                    		{field : 'id',title : '编号',width : 150,checkbox : true,align:'center'},
	          					{field : 'title',title : '标题',width : 150,align:'center'},
	          					{field : 'issuer',title : '发布人',width : 150,align:'center'},
      	                    	{field : 'action',title : '操作',width : 80,align : 'center',formatter : webinfo_list_actionFormatter} 
	                    		] ];
	/** 初始化DataGrid,加载数据 **/		
	function webinfo_list_loadDataGrid(){		 
		webinfo_list_datagrid = $('#'+webinfo_list_datagrid_id).datagrid({
			url : webinfo_list_datagrid_load_url,
			fit : true,
			border : false,
			fitColumns : true,
			singleSelect : false,
			striped : true,
			pagination : true,
			rownumbers : true,
			idField : 'id',
			pageSize : 15,
			pageList : [ 5, 10,15, 20, 30, 40, 50 ],
			columns : webinfo_list_datagrid_columns,
			toolbar:'#'+webinfo_list_toolbar_id,
			onLoadSuccess : function() {	
				$(this).datagrid('tooltip');
				$('#'+webinfo_list_searchform_id+' table').show();
				$('#'+webinfo_list_datagrid_id).show();
				$('#'+webinfo_list_toolbar_id).show();
				parent. $ .messager.progress('close');
			}
		});
	}
	$ .parser.onComplete = function() {
		//加载DataGrid数据
		webinfo_list_loadDataGrid();	
		//绑定按钮事件
		bindSearchBtn('webinfo_list_searchBtn','webinfo_list_clearBtn','webinfo_list_searchForm',webinfo_list_datagrid);
	};
</script>


