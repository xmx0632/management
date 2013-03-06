drop table if exists df_task;
drop table if exists df_user;

drop table if exists df_admin_role;
drop table if exists df_role;
drop table if exists df_admin;
drop table if exists df_team;

create table df_task (
	id bigint auto_increment,
	title varchar(128) not null,
	description varchar(255),
	user_id bigint not null,
    primary key (id)
);

create table df_user (
	id bigint auto_increment,
	login_name varchar(64) not null unique,
	name varchar(64) not null,
	password varchar(255) not null,
	salt varchar(64) not null,
	roles varchar(255) not null,
	register_date timestamp not null ,
	primary key (id)
);


/*shiro*/
create table df_role (
    id bigint auto_increment,
	name varchar(255) not null unique,
	permissions varchar(255),
    primary key (id)
);

create table df_admin (
   	id bigint auto_increment,
    login_name varchar(255) not null unique,
    name varchar(64),
    password varchar(255),
    salt varchar(64),
    email varchar(128),
    status varchar(32),
    team_id bigint,
    primary key (id)
);

create table df_admin_role (
    admin_id bigint not null,
    role_id bigint not null,
    primary key (admin_id, role_id)
);

create table df_team (
   	id bigint auto_increment,
	name varchar(255) not null unique,
	master_id bigint,
    primary key (id)
);

commit; 