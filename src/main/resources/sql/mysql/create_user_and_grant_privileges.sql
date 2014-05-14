use mysql;
DELETE FROM mysql.user WHERE User="management";
flush privileges;
--insert into mysql.user(Host,User,Password,ssl_cipher,x509_issuer,x509_subject) values("localhost","management",password("management"),'','','');
CREATE USER management IDENTIFIED BY 'management';
grant ALL PRIVILEGES ON management.* TO 'management'@'localhost' IDENTIFIED BY 'management' WITH GRANT OPTION;
flush privileges;
commit;