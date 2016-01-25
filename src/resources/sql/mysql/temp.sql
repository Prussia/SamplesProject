create table test_linkman(
		 id int(10) not null  auto_increment,
		 uuid varchar(100) null comment '',
		 name varchar(100) null comment '',
		 email varchar(100) null comment '//email地址',
		 sex varchar(100) null comment '',
		 phone varchar(100) null comment '',
		 phone2 varchar(100) null comment '',
		 remark varchar(100) null comment '',
		 birthday varchar(100) null comment '',
		 neckname varchar(100) null comment '',
		 qq varchar(100) null comment '',
		 company varchar(100) null comment '',
		 post varchar(100) null comment '',
 PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
 