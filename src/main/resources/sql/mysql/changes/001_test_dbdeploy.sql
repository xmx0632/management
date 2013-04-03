drop table if exists tbl_test_dbdeploy;
create table tbl_test_dbdeploy (
	id int auto_increment,
	`name` varchar(64),
	primary key (id)
);

insert into tbl_test_dbdeploy (`name`) values('admin');

--//@UNDO

DROP TABLE tbl_test_dbdeploy;