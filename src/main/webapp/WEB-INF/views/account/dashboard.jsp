<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />

<html>
<head>
<title><s:message code="common.nav.overview" /></title>
</head>
<body>
	<div>
		<ul class="breadcrumb">
			<li>
				<a href="#">Home</a> <span class="divider">/</span>
			</li>
			<li>
				<a href="#"><s:message code="common.nav.overview" /></a>
			</li>
		</ul>
	</div>
	<div class="sortable row-fluid">
		<a data-rel="tooltip" title="<s:message code="dashboard.total.new.member" arguments="${lastestRegisterMobileUserCount}" />" 
			class="well span3 top-block" href="${ctx}/admin/userAccount">
			<span class="icon32 icon-red icon-user"></span>
			<div><s:message code="dashboard.total.member"/></div>
			<div>${totalUserCount }</div>
			<span class="notification">${lastestRegisterMobileUserCount}</span>
		</a>

		<a data-rel="tooltip" title="<s:message code="dashboard.mobile.new.member" arguments="${lastestRegisterMobileUserCount }" />" 
			class="well span3 top-block" href="#">
			<span class="icon32 icon-color icon-star-on"></span>
			<div><s:message code="dashboard.mobile.member"/></div>
			<div>${mobileUserCount }</div>
			<span class="notification green">${lastestRegisterMobileUserCount }</span>
		</a>
		
		<a data-rel="tooltip" title="<s:message code="dashboard.new.sales" arguments="${newSales }" />" class="well span3 top-block" href="#">
			<span class="icon32 icon-color icon-cart"></span>
			<div><s:message code="dashboard.sales"/></div>
			<div><s:message code="dashboard.total.sales" arguments="${totalSales }" /></div>
			<span class="notification yellow"><s:message code="dashboard.new.sales" arguments="${newSales }" /></span>
		</a>
		
		<a data-rel="tooltip" title="" class="well span3 top-block" href="#">
			<span class="icon32 icon-color icon-envelope-closed"></span>
			<div><s:message code="dashboard.item1"/></div>
			<div>5</div>
		</a>
	</div>
	<div class="sortable row-fluid">
		<a data-rel="tooltip" title="" class="well span3 top-block" href="#">
			<span class="icon32 icon-color icon-envelope-closed"></span>
			<div><s:message code="dashboard.item2"/></div>
			<div>10</div>
		</a>
		
		<a data-rel="tooltip" title="" class="well span3 top-block" href="#">
			<span class="icon32 icon-color icon-envelope-closed"></span>
			<div><s:message code="dashboard.item3"/></div>
			<div>15</div>
		</a>
	</div>
</body>
</html>