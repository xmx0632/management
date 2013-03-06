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
				<div class="span8 ">
					<a class="btn" href="${ctx}/admin/apiMonitor/reset">重置接口统计</a>
				</div>
				<br>&nbsp;
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
					<thead>
						<tr>
							<th><s:message code="apiStat.name"/></th>
							<th><s:message code="apiStat.counter"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${stats}" var="stat">
							<tr>
							    <td>${stat.name}</td>
							    <td>${stat.counter}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
