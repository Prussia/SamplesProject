create table test_webinfo(
	id int(11) not null  auto_increment,
	uuid varchar(100) null comment 'uuid',
	title varchar(100) null comment '标题',
	issuer varchar(40) null comment '发布人',
	content text null comment '发布内容',
	creater varchar(40) null comment '创建者',
	create_date varchar(40) null comment '创建时间',
	create_ip varchar(40) null comment '创建者IP',
	updater varchar(40) null comment '更新者',
	update_date varchar(40) null comment '更新日期',
	update_ip varchar(40) null comment '更新者IP',
	state varchar(10) null default '0' comment '状态，0:正常；1:已删除',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 comment '新闻公告发布案例';

