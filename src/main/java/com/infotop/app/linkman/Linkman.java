package com.infotop.app.linkman;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.infotop.common.IdEntity;

/**
 * 联系人表，用于处理mail
 * 2015年11月8日下午2:22:58
 */
@Entity
@Table(name="test_linkman")
public class Linkman extends IdEntity {

	private String uuid;
	private String name;
	private String email;	//email地址
	private String sex;
	private String phone;
	private String phone2;
	private String remark;
	private String birthday;
	private String neckName;
	private int qq;
	private String company;
	private String post;
}
