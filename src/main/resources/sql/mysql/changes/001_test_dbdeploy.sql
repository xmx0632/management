drop table if exists tbl_test_user;
create table tbl_test_user (
	id bigint auto_increment,
	login_name varchar(64) not null,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	register_date timestamp not null ,
	sex varchar(1) not null comment '性别,0:男;1:女',
	email varchar(255) not null comment 'email',
	mobile varchar(11) not null comment '手机',
	birthday date not null comment '出生日期',
	account decimal(10,2) null default 0 comment '储值账户余额',
	credit int null default 0 comment '积分余额',
	remark varchar(255) null comment '备注',
	primary key (id)
);

insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(1,'admin','Admin','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','2012-06-04 01:00:00','0','admin@dd.com','13800138000','1988-08-08',0,0,'测试移动用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(2,'user0','Calvin1','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user0@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(3,'user1','Calvin2','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user1@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(4,'user2','Calvin3','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user2@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(5,'user3','Calvin4','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user3@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(6,'user4','Calvin5','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user4@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(7,'user5','Calvin6','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user5@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(8,'user6','Calvin7','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user6@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');
insert into tbl_test_user (id, login_name, name, password, salt, register_date, sex, email, mobile, birthday, account, credit, remark) values(9,'user7','Calvin8','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','2012-06-04 02:00:00','1','user7@ee.com','18011112222','1980-01-01',0,0,'测试电信用户');

commit; 


--//@UNDO

DROP TABLE tbl_test_user;