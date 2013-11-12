management
==============

quick start
------------

环境准备:安装了java1.6+,ant和maven，能联网

执行bin/init_maven_repo.bat,安装springside相关jar包到本地maven仓库

执行bin/package.bat,测试打包是否正常,可以自动下载依赖的jar包,并打出war即为正常.

0.启动mysql服务,确保配置文件中的数据库登录信息正确

   a.应用程序中的数据库配置信息：
   /management/src/main/resources/application.properties

   b.增量升级数据库脚本的数据库配置信息：
   /management/pom.xml中properties节点下12345678修改为数据库root密码
   <jdbc.upgrade.password>12345678</jdbc.upgrade.password>

   c.代码生成器使用的数据库配置信息：
   /management/bin/hibernate/hibernate.cfg.xml

1.顺序执行bin/refresh-db.bat和bin/upgrade-db.bat,新建management数据库和对应用户

2.执行bin/tomcat.bat或者bin/jetty.bat启动web服务

3.访问http://localhost:8888/management


-------------------------------------------------------------------
						单表CRUD代码生成
-------------------------------------------------------------------
1.新增数据库变更脚本到目录:/management/src/main/resources/sql/mysql/changes/
	增量脚本命名约定,必须按顺序递增：
	001_create_table.sql
	002_insert_data.sql
	003_升级内容说明.sql
	...
	00N_create_tbl_test_dbdeploy.sql
2.执行bin/upgrade-db.bat执行数据库变更到开发数据库
3.修改/management/bin/hibernate/hibernate.reveng.xml,指定需要生成代码的表名
4.执行/management/bin/hibernate/generate-code.bat,生成CRUD代码
5.执行bin/tomcat.bat或者bin/jetty.bat启动web服务
6.访问新增的页面链接:http://localhost:8888/management/admin/testUser


-------------------------------------------------------------------
						细节介绍
-------------------------------------------------------------------
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
然后用workbench导出一个表结构的sql即可,保证只需要维护一份增量脚本

2.每次对数据库的变更放在文件夹:/management/src/main/resources/sql/mysql/changes/

[3]增量脚本命名约定,必须按顺序递增：
001_create_table.sql
002_insert_data.sql
003_升级内容说明.sql
....
00N_xxx.sql

3.增量sql脚本书写规范参考/management/src/main/resources/sql/mysql/changes/001_test_dbdeploy.sql
	
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
	2.执行/management/bin/dbdeploy/generate-upgrade-script.bat
	3.生成的output.sql就是增量升级脚本
	4.生成的undo.sql就是增量回滚脚本

7.只有第一次安装系统的时候才需要执行(重要!!!)
bin/refresh-db.bat
