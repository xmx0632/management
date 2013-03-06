drop table if exists tbl_config;
create table tbl_config (
	id bigint auto_increment,
	name varchar(64) not null unique comment '配置项名称' ,
	config_value varchar(255) not null comment '配置项值' ,
	description varchar(255) not null comment '配置项描述' ,
	primary key (id)
);

/* 用户管理  */
drop table if exists tbl_user_account;
create	table tbl_user_account (
	id bigint not null auto_increment,
	customer_id varchar(20) null comment '客户编号' ,
	customer_name varchar(50) null comment '客户名称' ,
	sex varchar(1) null default 0 comment '性别,0:男;1:女' ,
	mobile varchar(11) null comment '手机' ,
	telephone varchar(16) null comment '电话' ,
	province varchar(5) null comment '省份' ,
	city varchar(10) null comment '市' ,
	district varchar(10) null comment '区' ,
	county varchar(10) null comment '县' ,
	address varchar(255) null comment '地址' ,
	area varchar(50) null comment '地址区域' ,
	zip_code varchar(6) null comment '邮编',
	email varchar(255) not null comment 'email' ,
	birthday date null comment '出生日期' ,
	platform varchar(1) null comment '客户来源:0=手机平台;1=ERP平台' ,
	username varchar(50) not null comment '登录名' ,
	password varchar(50) not null comment '密码,md5加密' ,
	account decimal(10,2) null default 0 comment '储值账户余额',
	credit int null default 0 comment '积分余额',
	group_info varchar(20) null comment '所属组(TBD)' ,
	remark varchar(255) null comment '备注' ,
	register_date timestamp null comment '注册日期',
	create_time timestamp null comment '创建时间',
	status varchar(1) null default 0 comment '用户状态,0:正常;1:冻结' ,
	primary key (id) 
)comment = '会员信息';

commit; 
