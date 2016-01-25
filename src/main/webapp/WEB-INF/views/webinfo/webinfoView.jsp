<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>

<div id="three">
	<div class="contenttable">
		<h3>
			<spring:message code="webinfo_title" />
		</h3>
		<div class="contenttable1">
			<table class="content" style="width: 99%;" >
				 				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_uuid" /></td>
					<td>${ webinfo.uuid }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_title" /></td>
					<td>${ webinfo.title }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_issuer" /></td>
					<td>${ webinfo.issuer }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_content" /></td>
					<td>${ webinfo.content }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_creater" /></td>
					<td>${ webinfo.creater }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_createDate" /></td>
					<td>${ webinfo.createDate }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_createIp" /></td>
					<td>${ webinfo.createIp }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_updater" /></td>
					<td>${ webinfo.updater }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_updateDate" /></td>
					<td>${ webinfo.updateDate }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_updateIp" /></td>
					<td>${ webinfo.updateIp }</td>
				</tr>
				  				<tr>
					<td class="biao_bt3"><spring:message
							code="webinfo_state" /></td>
					<td>${ webinfo.state }</td>
				</tr>
				   			</table>
		</div>
	</div>
</div>
<script type="text/javascript">
$ .parser.onComplete = function() {
	parent.$ .messager.progress('close');
};
</script>



