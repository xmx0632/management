management
==============

management management



执行bin/package.bat,测试打包是否正常,下载依赖的jar包

0.启动mysql服务,修改mysql数据库root用户密码配置
/management/src/main/resources/application.properties
jdbc.password=你的数据库密码


1.数据库初始化脚本:
建schema:/management/src/main/resources/sql/mysql/create_schema.sql

[后台管理用户权限表,与系统功能无关,尽量不动]
建表结构:/management/src/main/resources/sql/mysql/schema_admin.sql
初始化数据:management/src/main/resources/sql/mysql/schema_admin-init.sql

[系统功能相关的表结构,主要改这里]
建表结构:/management/src/main/resources/sql/mysql/schema.sql
初始化数据:management/src/main/resources/sql/mysql/schema-init.sql

执行初始化数据库脚本:
/management/bin/refresh-db.bat

2.代码生成:
修改/management/bin/hibernate/hibernate.cfg.xml，修改hibernate.connection.password指定数据库密码
修改/management/bin/hibernate/hibernate.reveng.xml,指定需要生成代码的表名
执行/management/bin/hibernate/generate-code.bat

*** 多表关联关系情况下不建议用hibernate-tool生成entity文件，手写更简洁：
手写entity参考：
admin-role：1 to N
admin-team：N to 1
user-task ： 1 to N

-------------------------------------------------------------------
预备知识,即用即查:
spring mvc
http://static.springsource.org/autorepo/docs/spring-framework/current/spring-framework-reference/html/mvc.html


支持主题样式修改,需要改charisma.js文件中的路径,调试时暂时写死:
	function switch_theme(theme_name)
	{
		$('#bs-css').attr('href','http://localhost:8888/management/static/css/bootstrap-'+theme_name+'.css');
	}
	

	
-------------------------------------------------------------------
						开发维护注意事项
-------------------------------------------------------------------
对数据库的修改按照如下约定:

1.如果需要全部的sql,只要执行所有增量脚本,数据库里的就是最新的全部表结构
然后用workbench导出一个表结构的sql就可以,保证只需要维护一份增量脚本

2.每次对数据库的变更放在文件夹:/deliciousfruit/src/main/resources/sql/mysql/changes/

[3]增量脚本命名约定,必须按顺序递增：
001_create_table.sql
002_insert_data.sql
003_升级内容说明.sql
....
00N_xxx.sql

3.增量sql脚本书写规范参考/deliciousfruit/src/main/resources/sql/mysql/changes/001_test_dbdeploy.sql
	
	drop table if exists tbl_test_dbdeploy;
	create table tbl_test_dbdeploy (
		id int auto_increment,
		`name` varchar(64),
		primary key (id)
	);
	
	insert into tbl_test_dbdeploy (`name`) values('admin');
	
	--//@UNDO
	
	DROP TABLE tbl_test_dbdeploy;
	
其中,--//@UNDO之前的是升级脚本,	--//@UNDO之前的是对应的回滚脚本

4.不对原来的sql文件做任何变更(重要!!!)

5.对已有数据库的增量更新
执行bin/upgrade-db.bat即可更新到最新的表结构

6.合并生成某个版本之后的增量脚本
	1.在本地数据库changelog表中指定要生成的起始版本
	2.执行/deliciousfruit/bin/dbdeploy/generate-upgrade-script.bat
	3.生成的output.sql就是增量升级脚本
	4.生成的undo.sql就是增量回滚脚本

7.只有第一次安装系统的时候才需要执行(重要!!!)
bin/refresh-db.bat

