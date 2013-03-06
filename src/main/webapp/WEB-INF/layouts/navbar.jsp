<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div class="navbar-inner">
	<div class="container-fluid">
		<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
			<span class="icon-bar"></span>
		</a>
		<a class="brand" href="${ctx}"> <img alt="Charisma Logo" src="${ctx}/static/img/logo20.png" /> <span><s:message code="common.site.title"/></span></a>
		
		<div class="btn-group pull-right" >
			<button id="toggle-fullscreen" class="btn btn-large btn-primary visible-desktop" data-toggle="button"><s:message code="common.nav.toggle.fullscreen"/></button>
		</div>
		
		<!-- theme selector starts -->
		<div class="btn-group pull-right theme-container" >
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="icon-tint"></i><span class="hidden-phone"> <s:message code="common.nav.change.theme"/></span>
				<span class="caret"></span>
			</a>
			<ul class="dropdown-menu" id="themes">
				<li><a data-value="classic" href="?theme=classic"><i class="icon-blank"></i> Classic</a></li>
				<li><a data-value="cerulean" href="?theme=cerulean"><i class="icon-blank"></i> Cerulean</a></li>
				<li><a data-value="cyborg" href="?theme=cyborg"><i class="icon-blank"></i> Cyborg</a></li>
				<li><a data-value="redy" href="?theme=redy"><i class="icon-blank"></i> Redy</a></li>
				<li><a data-value="journal" href="?theme=journal"><i class="icon-blank"></i> Journal</a></li>
				<li><a data-value="simplex" href="?theme=simplex"><i class="icon-blank"></i> Simplex</a></li>
				<li><a data-value="slate" href="?theme=slate"><i class="icon-blank"></i> Slate</a></li>
				<li><a data-value="spacelab" href="?theme=spacelab"><i class="icon-blank"></i> Spacelab</a></li>
				<li><a data-value="united" href="?theme=united"><i class="icon-blank"></i> United</a></li>
			</ul>
		</div>
		<!-- theme selector ends -->
		
		<!-- user dropdown starts -->
		<div class="btn-group pull-right" >
			<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
				<i class="icon-user"></i><span class="hidden-phone"><s:message code="common.nav.admin"/></span>
				<span class="caret"></span>
			</a>
			<ul class="dropdown-menu">
				<shiro:hasRole name="Admin">
				<li><a href="${ctx}/account/admin"><s:message code="common.nav.adminUsers"/></a></li>
				<li><a href="${ctx}/admin/apiMonitor">API Monitor</a></li>
				<li><a href="${ctx}/druid" target="blank">Druid Monitor</a></li>
				<li class="divider"></li>
				</shiro:hasRole>
				<li><a href="${ctx}/profile"><s:message code="common.nav.profile"/></a></li>
				<li class="divider"></li>
				<li><a href="${ctx}/logout"><s:message code="common.nav.logout"/></a></li>
			</ul>
		</div>
		<!-- user dropdown ends -->
		
		<div class="top-nav nav-collapse">
			<ul class="nav">
				<li id="dashboard"><a href="${ctx}/dashboard" title="<s:message code="common.nav.overview"/>"><s:message code="common.nav.overview"/></a></li>
				<li id="config"><a href="${ctx}/admin/config" title="<s:message code="common.nav.systemConfig"/>"><s:message code="common.nav.systemConfig"/></a></li>
				<li>
					<form class="navbar-search pull-left">
						<input placeholder="Search" class="search-query span2" name="query" type="text">
					</form>
				</li>
            </ul>
		</div><!--/.nav-collapse -->
	</div>
</div>