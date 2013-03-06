<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>



<html>
<head>
<title>
<s:message code="testUser"/><s:message code="common.management"/>
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
					<label><s:message code="testUser.loginName"/>:</label> <input type="text" name="search_LIKE_loginName"
						class="input-medium" value="${param.search_LIKE_loginName}">
					<button type="submit" class="btn"><s:message code="common.search"/></button>
				</form>
			</div>
			<tags:sort />
		
			<table id="contentTable"
				class="table table-striped table-bordered table-condensed">
				<thead>
					<tr>
						<th><s:message code="testUser.loginName"/></th>
						<th><s:message code="testUser.name"/></th>
						<th><s:message code="testUser.registerDate"/></th>
						<th><s:message code="testUser.sex"/></th>
						<th><s:message code="testUser.email"/></th>
						<th><s:message code="testUser.mobile"/></th>
						<th><s:message code="testUser.birthday"/></th>
						<th><s:message code="testUser.account"/></th>
						<th><s:message code="testUser.credit"/></th>
						<th><s:message code="testUser.remark"/></th>
						<th><s:message code="common.management"/></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${testUsers.content}" var="testUser">
						<tr>
						    <td><a href="${ctx}/admin/testUser/update/${testUser.id}">${testUser.loginName}</a></td>
						    <td>${testUser.name}</td>
							<td><fmt:formatDate value="${testUser.registerDate}"
									pattern="yyyy-MM-dd HH:mm:ss" /></td>
						    <td>${testUser.sex}</td>
						    <td>${testUser.email}</td>
						    <td>${testUser.mobile}</td>
							<td><fmt:formatDate value="${testUser.birthday}"
									pattern="yyyy年MM月dd日" /></td>
						    <td>${testUser.account}</td>
						    <td>${testUser.credit}</td>
						    <td>${testUser.remark}</td>
							<td><a class="btn btn-danger" href="${ctx}/admin/testUser/delete/${testUser.id}"><i class="icon-trash icon-white"></i><s:message code="common.delete"/></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	
		<tags:pagination page="${testUsers}" paginationSize="5" />
		</div>
	</div>

	<div>
		<a class="btn" href="${ctx}/admin/testUser/create"><s:message code="common.create"/><s:message code="testUser"/></a>
	</div>
</body>
</html>
