package com.infotop.app.magazine.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.infotop.common.IdEntity;

/**
 * 杂志显示
 * 2015年11月8日上午11:34:49
 */
@Entity
@Table(name="test_magazine")
public class Magazine extends IdEntity {

	private String uuid;
	private String title;
	private String coverImg;//封面图片
	private String brief;//简介
	private String attachment;  //附件
	private String creater;
	private String createDate;
	private String updater;
	private String updateDate;
	
}
