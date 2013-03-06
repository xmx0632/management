insert into df_task (id, title, description, user_id) values(1, 'Study PlayFramework 2.0','http://www.playframework.org/', 2);
insert into df_task (id, title, description, user_id) values(2, 'Study Grails 2.0','http://www.grails.org/', 2);
insert into df_task (id, title, description, user_id) values(3, 'Try SpringFuse','http://www.springfuse.com/', 2);
insert into df_task (id, title, description, user_id) values(4, 'Try Spring Roo','http://www.springsource.org/spring-roo', 2);
insert into df_task (id, title, description, user_id) values(5, 'Release SpringSide 4.0','As soon as posibble.', 2);

insert into df_user (id, login_name, name, password, salt, roles, register_date) values(1,'admin','Admin','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','admin','2012-06-04 01:00:00');
insert into df_user (id, login_name, name, password, salt, roles, register_date) values(2,'user','Calvin','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','user','2012-06-04 02:00:00');



/*shiro*/
insert into df_admin (id, login_name, name, email, password, salt, status, team_id) values(1,'admin','管理员','admin@springside.org.cn','691b14d79bf0fa2215f155235df5e670b64394cc','7efbd59d9741d34f','enabled',1);
insert into df_admin (id, login_name, name, email, password, salt, status, team_id) values(2,'user','Calvin','user@springside.org.cn','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into df_admin (id, login_name, name, email, password, salt, status, team_id) values(3,'user2','Jack','jack@springside.org.cn','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into df_admin (id, login_name, name, email, password, salt, status, team_id) values(4,'user3','Kate','kate@springside.org.cn','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into df_admin (id, login_name, name, email, password, salt, status, team_id) values(5,'user4','Sawyer','sawyer@springside.org.cn','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);
insert into df_admin (id, login_name, name, email, password, salt, status, team_id) values(6,'user5','Ben','ben@springside.org.cn','2488aa0c31c624687bd9928e0a5d29e7d1ed520b','6d65d24122c30500','enabled',1);

insert into df_role (id, name, permissions) values(1,'Admin','user:view,user:edit');
insert into df_role (id, name, permissions) values(2,'User','user:view');

insert into df_admin_role (admin_id, role_id) values(1,1);
insert into df_admin_role (admin_id, role_id) values(1,2);
insert into df_admin_role (admin_id, role_id) values(2,2);
insert into df_admin_role (admin_id, role_id) values(3,2);
insert into df_admin_role (admin_id, role_id) values(4,2);
insert into df_admin_role (admin_id, role_id) values(5,2);
insert into df_admin_role (admin_id, role_id) values(6,2);

insert into df_team (id, name, master_id) values(1,'Dolphin',1);

commit; 