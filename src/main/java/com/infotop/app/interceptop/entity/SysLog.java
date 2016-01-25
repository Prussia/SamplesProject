package com.infotop.app.interceptop.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.infotop.common.IdEntity;

@Entity
@Table(name="cs_sys_log")
public class SysLog extends IdEntity {

	private Long userId;
	private String userLoginName;
	private String userName;
	private String operateDate;
	private String operateMethodName;
	private String operateMethodCodeName;
	private String operationIp;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserLoginName() {
		return userLoginName;
	}
	public void setUserLoginName(String userLoginName) {
		this.userLoginName = userLoginName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getOperateDate() {
		return operateDate;
	}
	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}
	public String getOperateMethodName() {
		return operateMethodName;
	}
	public void setOperateMethodName(String operateMethodName) {
		this.operateMethodName = operateMethodName;
	}
	public String getOperateMethodCodeName() {
		return operateMethodCodeName;
	}
	public void setOperateMethodCodeName(String operateMethodCodeName) {
		this.operateMethodCodeName = operateMethodCodeName;
	}
	public String getOperationIp() {
		return operationIp;
	}
	public void setOperationIp(String operationIp) {
		this.operationIp = operationIp;
	}
	
}
