package com.infotop.system.parameter.entity;
/**
 * 脑图专用，仿冒必究
 * 
 * 2015年11月11日下午3:19:50
 */
public class JsMind {
	private String id;
	private String parentid;
	private String topic;	//标题
	private boolean isroot;	//是否根节点
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getParentid() {
		return parentid;
	}
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public boolean getIsroot() {
		return isroot;
	}
	public void setIsroot(boolean isroot) {
		this.isroot = isroot;
	}
}
