<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/taglibs.jsp"%>
<div class="easyui-accordion"
	data-options="fit:true,iconCls:'icon-ok',border:false">
	
	<div class="menuItem" title='案例' data-options="iconCls:'icon-cog'"
		style="padding: 10px;">
		<ul>
			<li><a data-options="plain:true" href="javascript:void(0)"
				class="user easyui-linkbutton"
				onclick="indexTabsAddTab('href',{title:'通知公告案例',url:'${ctx}/webinfo',iconCls:'icon-user_gray'})">
					<img
					src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/user_gray.png" />&nbsp;通知公告案例
			</a></li>
			<li><a data-options="plain:true" href="javascript:void(0)"
				class="user easyui-linkbutton"
				onclick="indexTabsAddTab('href',{title:'脑图小案例',url:'${ctx}/parameter/jsmindForm',iconCls:'icon-user_gray'})">
					<img
					src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/user_gray.png" />&nbsp;脑图小案例
			</a></li>
		</ul>
	</div>
	
	<div class="menuItem" title='系统设置' data-options="iconCls:'icon-cog'"
		style="padding: 10px;">
		<ul>
			<li><a data-options="plain:true" href="javascript:void(0)"
				class="user easyui-linkbutton"
				onclick="indexTabsAddTab('href',{title:'用户管理',url:'${ctx}/account/user',iconCls:'icon-user_gray'})">
					<img
					src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/user_gray.png" />&nbsp;用户管理
			</a></li>
			<li><a data-options="plain:true" href="javascript:void(0)"
				class="user easyui-linkbutton"
				onclick="indexTabsAddTab('href',{title:'角色管理',url:'${ctx}/account/role',iconCls:'icon-group_key'})">
					<img
					src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/group_key.png" />&nbsp;角色管理
			</a></li>
			<li><a data-options="plain:true" href="javascript:void(0)"
				class="user easyui-linkbutton"
				onclick="indexTabsAddTab('href',{title:'权限管理',url:'${ctx}/account/permission',iconCls:'icon-key'})">
					<img src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/key.png" />&nbsp;权限管理
			</a></li>
			<li><a data-options="plain:true" href="javascript:void(0)"
				class="user easyui-linkbutton"
				onclick="indexTabsAddTab('href',{title:'参数管理',url:'${ctx}/parameter',iconCls:'icon-plugin'})">
					<img
					src="${ctx}/static/js/plugins/jquery-easyui-1.3.4/themes/icons/plugin.png" />&nbsp;参数管理
			</a></li>
		</ul>
	</div>
</div>



