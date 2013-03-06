<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>



<html>
<head>
<title>
<s:message code="userAccount"/><s:message code="common.management"/>
</title>
</head>

<body>
	<div class="row-fluid sortable">		
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><s:message code="common.search.result"/></h2>
				<div class="box-icon">
				</div>
			</div>
			<div class="box-content">
			
			<%@ include file="/WEB-INF/views/common/messages.jsp" %>
			<div class="span8 offset0">
				<form class="form-search" action="#">
					<label><s:message code="userAccount.customerId"/>:</label> <input type="text" name="search_LIKE_customerId"
						class="input-medium" value="${param.search_LIKE_customerId}">
					<label><s:message code="userAccount.mobile"/>：</label> <input type="text" name="search_EQ_mobile" 
						class="input-small" value="${param.search_EQ_mobile}">
					<label><s:message code="userAccount.username"/>：</label> <input type="text" name="search_EQ_username" 
						class="input-small" value="${param.search_EQ_username}">
					<button type="submit" class="btn"><s:message code="common.search"/></button>
				</form>
			</div>
			<tags:sort />
			
			<table id="contentTable"
				class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th><s:message code="userAccount.customerId"/></th>
						<th><s:message code="userAccount.sex"/></th>
						<th><s:message code="userAccount.mobile"/></th>
						<th><s:message code="userAccount.email"/></th>
						<th><s:message code="userAccount.platform"/></th>
						<th><s:message code="userAccount.username"/></th>
						<th><s:message code="userAccount.registerDate"/></th>
						<th><s:message code="userAccount.status"/></th>
						<th><s:message code="common.management"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${userAccounts.content}" var="userAccount">
						<tr>
						    <td>${userAccount.customerId}</td>
						    <td>${allGender[userAccount.sex]}</td>
						    <td>${userAccount.mobile}</td>
						    <td>${userAccount.email}</td>
						    <td>${allPlatform[userAccount.platform]}</td>
						    <td>${userAccount.username}</td>
							<td><fmt:formatDate value="${userAccount.registerDate}"
									pattern="yyyy年MM月dd日" /></td>
							<td>
								<c:if test="${userAccount.status == '0'}">
								<span class="label label-success">${allStatus[userAccount.status]}</span>
								</c:if>
								<c:if test="${userAccount.status == '1'}">
								<span class="label label-important">${allStatus[userAccount.status]}</span>
								</c:if>
							</td>
							<td>
								<a class="btn btn-success" href="${ctx}/admin/userAccount/update/${userAccount.id}"><i class="icon-edit icon-white"></i><s:message code="common.view"/></a>
								<a class="btn btn-danger" href="${ctx}/admin/userAccount/delete/${userAccount.id}"><i class="icon-edit icon-white"></i><s:message code="common.delete"/></a>
								<c:if test="${userAccount.status == '0'}">
								<a class="btn btn-info" href="${ctx}/admin/userAccount/ban/${userAccount.id}"><i class="icon-edit icon-white"></i><s:message code="common.ban"/></a>
								</c:if>
								<c:if test="${userAccount.status == '1'}">
								<a class="btn btn-info" href="${ctx}/admin/userAccount/unban/${userAccount.id}"><i class="icon-trash icon-white"></i><s:message code="common.unban"/></a>
								</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		
			<tags:pagination page="${userAccounts}" paginationSize="5" />
			</div>
		</div>
		
		<%-- 
		<div>
			<a class="btn" href="${ctx}/admin/userAccount/create"><s:message code="common.create"/><s:message code="userAccount"/></a>
		</div>
		 --%>
	</div>
</body>
</html>
