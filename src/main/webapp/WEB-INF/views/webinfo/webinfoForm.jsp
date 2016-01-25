<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<!-- 使用的ckeditor.js路径 -->
<script src="${ctx }/static/js/plugins/ckeditor/ckeditor.js"></script>



<script type="text/javascript">
var webinfo_form_inputform_id = 'webinfo_form_inputForm';

$ .parser.onComplete = function() {
		parent. $ .messager.progress('close');
		$('#'+webinfo_form_inputform_id).form(
				{
					onSubmit : function() {
						parent. $ .messager.progress({
							title : '提示',
							text : '数据处理中，请稍后....'
						});
						var isValid = $(this).form('validate');
						if (!isValid) {
							parent. $ .messager.progress('close');
						}
						return isValid;
					},
					success : function(result) {
						parent. $ .messager.progress('close');
						result = $ .parseJSON(result);
						if (result.success) {
							parent. $ .modalDialog.openner_dataGrid
									.datagrid('reload');
							parent. $ .modalDialog.openner_dataGrid.datagrid(
									'uncheckAll').datagrid('unselectAll')
									.datagrid('clearSelections');
							parent. $ .modalDialog.handler.dialog('close');
							$ .messager.show({ // show error message
								title : '提示',
								msg : result.message
							});
						} else {
							$ .messager.alert('错误', result.message, 'error');
						}
					}
				});

	} ;
</script>

<form:form id="webinfo_form_inputForm" name="webinfo_form_inputForm" action="${ctx}/webinfo/${action}"
		 modelAttribute="webinfo" method="post" class="form-horizontal">
	<input type="hidden" name="id" id="id" value="${ webinfo.id}" />
	<table class="content" style="width: 100%;">
  		<tr>
			<td class="biao_bt3">标题</td>
			<td>
				<input type="text" name="title" id="title" value="${ webinfo.title }" class="easyui-validatebox long_input" 
					data-options="missingMessage:'标题不能为空.',required:true"   />	
			</td>
		</tr>
  		<tr>
			<td class="biao_bt3">发布人</td>
			<td>
				<input type="text" name="issuer" id="issuer" value="${ webinfo.issuer }" 
					class="easyui-validatebox" data-options="missingMessage:'发布人不能为空.',required:true"   />	
			</td>
		</tr>
  		<tr>
			<td class="biao_bt3" colspan="2">发布内容</td>
		</tr>
		<tr>
			<td colspan="2">	
				<textarea cols="100" rows="10" id="content" name="content">${ webinfo.content }</textarea>
				<script>
				    CKEDITOR.replace( 'content' ,
				    				{ 
					    				height: '300px', 
					    				width: '100%' ,
					    			   /*  filebrowserBrowseUrl:'${ctx}/webinfo/upload', */
					    			    filebrowserImageUploadUrl: '${ctx}/webinfo/upload',
					    			    filebrowserUploadUrl: '${ctx}/webinfo/upload',
					    			    filebrowserFlashUploadUrl: '${ctx}/webinfo/upload',
					                    toolbar: [
						                              ['Bold', 'Italic', '-', 'NumberedList', 'BulletedList', '-', 'Link', 'Unlink'],
						                              ['FontSize', 'TextColor', 'BGColor'],
						                              ['Image']
					                              ]
					                } );
				</script>
			</td>
		</tr>
	  		
   	</table>
</form:form>
	