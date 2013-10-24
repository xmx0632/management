use mysql;
DELETE FROM mysql.user WHERE User="management";
insert into mysql.user(Host,User,Password,ssl_cipher,x509_issuer,x509_subject) values("localhost","management",password("management"),'','','');
grant ALL PRIVILEGES ON management.* TO 'management'@'localhost' IDENTIFIED BY 'management' WITH GRANT OPTION;
flush privileges;
commit;