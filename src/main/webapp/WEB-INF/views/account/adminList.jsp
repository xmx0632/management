<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>
<html>
<head>
<title>管理员帐户管理</title>
</head>

<body>
	<%@ include file="/WEB-INF/views/common/messages.jsp" %>
	<div class="row">
		<div class="offset4">
			<form class="form-search" action="#">
				<label>登录名：</label> <input type="text" name="search_LIKE_loginName"
					class="input-small" value="${param.search_LIKE_loginName}">
				<label>邮件名：</label> <input type="text" name="search_EQ_email"
					class="input-small" value="${param.search_EQ_email}">
				<button type="submit" class="btn" id="search_btn">Search</button>
			</form>
		</div>
	</div>

	<table id="contentTable"
		class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<th>登录名</th>
				<th>姓名</th>
				<th>电邮</th>
				<th>角色</th>
				<th>状态</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.loginName}&nbsp;</td>
					<td>${user.name}&nbsp;</td>
					<td>${user.email}&nbsp;</td>
					<td>${user.roleNames}&nbsp;</td>
					<td>${allStatus[user.status]}&nbsp;</td>
					<td><shiro:hasPermission name="user:edit">
							<a href="${ctx}/account/admin/update/${user.id}"
								id="editLink-${user.loginName}">修改</a>
						</shiro:hasPermission></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
