<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header">
	<div id="title">
	    <h1>美果人生<small>--管理系统</small>
		<shiro:user>
		<div class="btn-group pull-right">
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="icon-user"></i> <shiro:principal property="name"/>
			<span class="caret"></span>
			</a>
		
			<ul class="dropdown-menu">
				<shiro:hasRole name="Admin">
				<li><a href="${ctx}/account/admin">Admin Users</a></li>
				<li><a href="${ctx}/druid" target="blank">Druid Monitor</a></li>
				<li class="divider"></li>
				</shiro:hasRole>
				<li><a href="${ctx}/profile">Edit Profile</a></li>
				<li><a href="${ctx}/logout">Logout</a></li>
			</ul>
		</div>
		</shiro:user>
		</h1>
	</div>
</div>

<div class="navbar">
  	<div class="navbar-inner">
    	<div class="container">
 
			<!-- .btn-navbar is used as the toggle for collapsed navbar content -->
			<a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			  <span class="icon-bar"></span>
			</a>
 
			<!-- Be sure to leave the brand out there if you want it shown -->
			<a class="brand" href="${ctx}/">美果人生</a>
			
			<!-- Everything you want hidden at 940px or less, place within here -->
			<div class="nav-collapse collapse">
                    <ul class="nav">
                      <li id="admin_userAccount"><a href="${ctx}/admin/userAccount" title="用户账号管理">用户账号</a></li>
                      <li id="admin_mobileUser"><a href="${ctx}/admin/mobileUser" title="手机用户管理">演示3</a></li>
                      <li id="account_user"><a href="${ctx}/account/user" title="用户账号管理,与“任务管理”有关联关系,演示用">演示1</a></li>
                      <li id="task_task"><a href="${ctx }/task/task" title="任务管理,与“用户账号管理”有关联关系,演示用">演示2</a></li>
                    </ul>
                    
                    <ul class="nav pull-right">
                      <li id="upload_upload"><a href="${ctx }/upload/upload/show">文件上传</a></li>
                      <li ><a target="_blank" href="${ctx }/api/v1/task/1" title="Task Json Api (ID可变)">Task</a></li>
                      <li ><a target="_blank" href="${ctx }/api/v2/user/1" title="User Json Api (ID可变)">User</a></li>
                      <!-- 
                      <li ><a target="_blank" href="${ctx }/api/v1/admin/1" title="Admin Xml Api (ID可变)">admin</a></li>
                      <li ><a target="_blank" href="${ctx }/api/v1/admin/1.xml" title="Admin Xml Api (ID可变)">admin</a></li>
                       -->
                      <li ><a target="_blank" href="${ctx }/api/v1/admin/1.json"  title="Admin Json Api (ID可变)">admin</a></li>
                    </ul>
                  </div><!-- /.nav-collapse -->
                  
    	</div>
  	</div>
</div>
<%
	String context = request.getContextPath()+"/";
	String uri = request.getRequestURI();
	//System.out.println("context:"+ context + " uri:"+uri);
	String middlePath = uri.replaceFirst(context, "");
	String [] pathArray = middlePath.split("/");
	String menuId = "";
	if(pathArray.length >= 2){
		menuId = pathArray[0] + "_" + pathArray[1];
	}
%>
<script>
	$(document).ready(function() {
		$("#<%=menuId%>").addClass("active");
	});
</script>