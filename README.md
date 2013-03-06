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