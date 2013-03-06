<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>

<head>
<title><s:message code="common.site.title"/>:密码修改</title>
<meta http-equiv="Content-Type" content="text/html;charset=utf-8" />
<meta http-equiv="Cache-Control" content="no-store" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />

	<link id="bs-css" href="${ctx}/<s:theme code='css'/>" rel="stylesheet">
	<!-- The styles -->
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	<!-- jQuery -->
	<script src="${ctx}/static/js/jquery-1.7.2.min.js"></script>
	<script src="${ctx}/static/jquery-validation/1.10.0/jquery.validate.min.js" type="text/javascript"></script>
	<script src="${ctx}/static/jquery-validation/1.10.0/messages_bs_zh.js" type="text/javascript"></script>
	<link href="${ctx}/static/jquery-validation/1.10.0/validate.css" type="text/css" rel="stylesheet" />

	<link href="${ctx}/static/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->
	
	<!-- The fav icon -->
	<link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">

	<title>密码重置</title>
	
	<script>
		$(document).ready(function() {
			//聚焦第一个输入框
			$("#name").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate();
		});
	</script>
</head>



<body>
	<form id="inputForm" action="${ctx}/resetPwd/reset" method="post" class="form-horizontal">
		<input type="hidden" name="id" value="${userAccount.id}"/>
		<fieldset>
			<legend><small>密码修改</small></legend>
			<div class="control-group">
				<label for="name" class="control-label">用户名:</label>
				<div class="controls">
					<span class="input-large uneditable-input">${userAccount.username}</span>
					<input type="hidden" id="username" name="username" value="${userAccount.username}" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPassword" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="plainPassword" name="plainPassword" class="input-large required" placeholder="...请输入新密码"/>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="input-large" equalTo="#plainPassword" />
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="<s:message code="common.submit"/>"/>&nbsp;	
			</div>
		</fieldset>
	</form>

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- library for cookie management -->
	<script src="${ctx}/static/js/jquery.cookie.js"></script>

	<!-- application script for Charisma demo -->
	<script src="${ctx}/static/js/charisma.js"></script>
	
</body>
</html>
