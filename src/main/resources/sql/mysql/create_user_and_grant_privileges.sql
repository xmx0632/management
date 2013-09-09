use mysql;
DELETE FROM mysql.user WHERE User="management";
insert into mysql.user(Host,User,Password) values("localhost","management",password("management"));
grant ALL PRIVILEGES ON management.* TO 'management'@'localhost' IDENTIFIED BY 'management' WITH GRANT OPTION;
flush privileges;
commit;