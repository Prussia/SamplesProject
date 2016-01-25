package com.infotop.app.interceptop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.infotop.app.interceptop.entity.SysLog;
import com.infotop.app.interceptop.service.SysLogService;
import com.infotop.system.account.service.ShiroDbRealm.ShiroUser;

import net.infotop.util.DateTimeUtil;

public class HandlerInterceptorAdapterTest extends HandlerInterceptorAdapter {

	@Autowired
	private SysLogService sysLogService;
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		
		SysLog info = new SysLog();
		info.setOperateDate(DateTimeUtil.nowTimeStr());
		info.setUserId(user.getId());
		info.setUserLoginName(user.getLoginName());
		info.setUserName(user.getName());
		sysLogService.save(info);
		
		
		
		super.afterCompletion(request, response, handler, ex);
	}
}
