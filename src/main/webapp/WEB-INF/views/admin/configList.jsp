<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>



<html>
<head>
<title>
<s:message code="config"/><s:message code="common.management"/>
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
						<label><s:message code="config.name"/>:</label> <input type="text" name="search_LIKE_name"
							class="input-medium" value="${param.search_LIKE_name}">
						<button type="submit" class="btn"><s:message code="common.search"/></button>
					</form>
				</div>
				<tags:sort />
			
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th><s:message code="config.name"/></th>
							<th><s:message code="config.configValue"/></th>
							<th><s:message code="config.description"/></th>
							<th><s:message code="common.management"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${configs.content}" var="config">
							<tr>
							    <td><a href="${ctx}/admin/config/update/${config.id}">${config.name}</a></td>
							    <td>${config.configValue}</td>
							    <td>${config.description}</td>
								<td><a class="btn btn-danger" href="${ctx}/admin/config/delete/${config.id}"><i class="icon-trash icon-white"></i><s:message code="common.delete"/></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
		
				<tags:pagination page="${configs}" paginationSize="5" />
			</div>
		</div>
	</div>

	<div>
		<a class="btn" href="${ctx}/admin/config/create"><s:message code="common.create"/><s:message code="config"/></a>
	</div>
</body>
</html>
