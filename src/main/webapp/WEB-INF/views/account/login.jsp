<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<%@ page import="org.apache.shiro.authc.ExcessiveAttemptsException"%>
<%@ page import="org.apache.shiro.authc.IncorrectCredentialsException"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<title><s:message code="common.site.title" /></title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta name="description" content="<s:message code="common.site.title" />">


	<!-- The styles -->
	<style type="text/css">
	  body {
		padding-bottom: 40px;
	  }
	  .sidebar-nav {
		padding: 9px 0;
	  }
	</style>
	
	<!-- The styles -->
	<link href="${ctx}/static/css/bootstrap-cerulean.css" rel="stylesheet">
	<link href="${ctx}/static/css/bootstrap-responsive.css" rel="stylesheet">
	<link href="${ctx}/static/css/charisma-app.css" rel="stylesheet">
	<link href="${ctx}/static/css/jquery-ui-1.8.21.custom.css" rel="stylesheet">
	<link href='${ctx}/static/css/fullcalendar.css' rel='stylesheet'>
	<link href='${ctx}/static/css/fullcalendar.print.css' rel='stylesheet'  media='print'>
	<link href='${ctx}/static/css/chosen.css' rel='stylesheet'>
	<link href='${ctx}/static/css/uniform.default.css' rel='stylesheet'>
	<link href='${ctx}/static/css/colorbox.css' rel='stylesheet'>
	<link href='${ctx}/static/css/jquery.cleditor.css' rel='stylesheet'>
	<link href='${ctx}/static/css/jquery.noty.css' rel='stylesheet'>
	<link href='${ctx}/static/css/noty_theme_default.css' rel='stylesheet'>
	<link href='${ctx}/static/css/elfinder.min.css' rel='stylesheet'>
	<link href='${ctx}/static/css/elfinder.theme.css' rel='stylesheet'>
	<link href='${ctx}/static/css/jquery.iphone.toggle.css' rel='stylesheet'>
	<link href='${ctx}/static/css/opa-icons.css' rel='stylesheet'>
	<link href='${ctx}/static/css/uploadify.css' rel='stylesheet'>

	<link href="${ctx}/static/bootstrap/2.1.1/css/bootstrap.min.css"
		type="text/css" rel="stylesheet" />
		
	<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
	<!--[if lt IE 9]>
	  <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
	<![endif]-->

	<!-- The fav icon -->
	<link rel="shortcut icon" href="${ctx}/static/img/favicon.ico">
		
</head>

<body>
		<div class="container-fluid">
		<div class="row-fluid">
		
			<div class="row-fluid">
				<div class="span12 center login-header">
					<h2>欢迎光临<s:message code="common.site.title" /></h2>
				</div><!--/span-->
			</div><!--/row-->
			
			<div class="row-fluid">
				<div class="well span5 center login-box">
					<div class="alert alert-info">
						请输入用户名和密码.
					</div>
						<%
							String error = (String) request
									.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
							if (error != null) {
						%>
						<div class="alert alert-error">
							<button class="close" data-dismiss="alert">×</button>
							登录失败，请重试.
						</div>
						<%
							}
						%>
					<form class="form-horizontal" action="${ctx}/login" method="post">
						<fieldset>
							<div class="input-prepend" title="Username" data-rel="tooltip">
								<span class="add-on"><i class="icon-user"></i></span><input autofocus class="input-large span10" name="username" id="username" type="text" value="${username}" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend" title="Password" data-rel="tooltip">
								<span class="add-on"><i class="icon-lock"></i></span><input class="input-large span10" name="password" id="password" type="password" value="" />
							</div>
							<div class="clearfix"></div>

							<div class="input-prepend">
							<label class="remember" for="rememberMe"><input type="checkbox" id="rememberMe" name="rememberMe" />Remember me</label>
							</div>
							<div class="clearfix"></div>

							<p class="center span5">
							<button type="submit" class="btn btn-primary">登录</button>
							</p>
						</fieldset>
					</form>
				</div><!--/span-->
			</div><!--/row-->
				</div><!--/fluid-row-->
		
	</div><!--/.fluid-container-->

	<!-- external javascript
	================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->

	<!-- jQuery -->
	<script src="${ctx}/static/js/jquery-1.7.2.min.js"></script>
	<!-- jQuery UI -->
	<script src="${ctx}/static/js/jquery-ui-1.8.21.custom.min.js"></script>
	<!-- transition / effect library -->
	<script src="${ctx}/static/js/bootstrap-transition.js"></script>
	<!-- alert enhancer library -->
	<script src="${ctx}/static/js/bootstrap-alert.js"></script>
	<!-- modal / dialog library -->
	<script src="${ctx}/static/js/bootstrap-modal.js"></script>
	<!-- custom dropdown library -->
	<script src="${ctx}/static/js/bootstrap-dropdown.js"></script>
	<!-- scrolspy library -->
	<script src="${ctx}/static/js/bootstrap-scrollspy.js"></script>
	<!-- library for creating tabs -->
	<script src="${ctx}/static/js/bootstrap-tab.js"></script>
	<!-- library for advanced tooltip -->
	<script src="${ctx}/static/js/bootstrap-tooltip.js"></script>
	<!-- popover effect library -->
	<script src="${ctx}/static/js/bootstrap-popover.js"></script>
	<!-- button enhancer library -->
	<script src="${ctx}/static/js/bootstrap-button.js"></script>
	<!-- accordion library (optional, not used in demo) -->
	<script src="${ctx}/static/js/bootstrap-collapse.js"></script>
	<!-- carousel slideshow library (optional, not used in demo) -->
	<script src="${ctx}/static/js/bootstrap-carousel.js"></script>
	<!-- autocomplete library -->
	<script src="${ctx}/static/js/bootstrap-typeahead.js"></script>
	<!-- tour library -->
	<script src="${ctx}/static/js/bootstrap-tour.js"></script>
	<!-- library for cookie management -->
	<script src="${ctx}/static/js/jquery.cookie.js"></script>
	<!-- calander plugin -->
	<script src='${ctx}/static/js/fullcalendar.min.js'></script>
	<!-- data table plugin -->
	<script src='${ctx}/static/js/jquery.dataTables.min.js'></script>

	<!-- chart libraries start -->
	<script src="${ctx}/static/js/excanvas.js"></script>
	<script src="${ctx}/static/js/jquery.flot.min.js"></script>
	<script src="${ctx}/static/js/jquery.flot.pie.min.js"></script>
	<script src="${ctx}/static/js/jquery.flot.stack.js"></script>
	<script src="${ctx}/static/js/jquery.flot.resize.min.js"></script>
	<!-- chart libraries end -->

	<!-- select or dropdown enhancer -->
	<script src="${ctx}/static/js/jquery.chosen.min.js"></script>
	<!-- checkbox, radio, and file input styler -->
	<script src="${ctx}/static/js/jquery.uniform.min.js"></script>
	<!-- plugin for gallery image view -->
	<script src="${ctx}/static/js/jquery.colorbox.min.js"></script>
	<!-- rich text editor library -->
	<script src="${ctx}/static/js/jquery.cleditor.min.js"></script>
	<!-- notification plugin -->
	<script src="${ctx}/static/js/jquery.noty.js"></script>
	<!-- file manager library -->
	<script src="${ctx}/static/js/jquery.elfinder.min.js"></script>
	<!-- star rating plugin -->
	<script src="${ctx}/static/js/jquery.raty.min.js"></script>
	<!-- for iOS style toggle switch -->
	<script src="${ctx}/static/js/jquery.iphone.toggle.js"></script>
	<!-- autogrowing textarea plugin -->
	<script src="${ctx}/static/js/jquery.autogrow-textarea.js"></script>
	<!-- multiple file upload plugin -->
	<script src="${ctx}/static/js/jquery.uploadify-3.1.min.js"></script>
	<!-- history.js for cross-browser state change on ajax -->
	<script src="${ctx}/static/js/jquery.history.js"></script>
	<!-- application script for Charisma demo -->
	<script src="${ctx}/static/js/charisma.js"></script>
	
		
</body>
</html>
