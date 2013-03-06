<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<html>
<head>
<title>testUser<s:message code="common.management"/></title>

<script>
	$(document).ready(function() {
		
		//聚焦第一个输入框
		$("#testUser_loginName").focus();
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/admin/testUser/${action}" method="post"
		class="form-horizontal">
		<input type="hidden" name="id" value="${testUser.id}" />
		<fieldset>
			<legend>
				<small><s:message code="common.management"/><s:message code="testUser"/></small>
			</legend>
			
			<div class="control-group">
				<label for="testUser_loginName" class="control-label"><s:message code="testUser.loginName"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_loginName" name="loginName"
					value="${testUser.loginName}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_name" class="control-label"><s:message code="testUser.name"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_name" name="name"
					value="${testUser.name}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_password" class="control-label"><s:message code="testUser.password"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_password" name="password"
					value="${testUser.password}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_salt" class="control-label"><s:message code="testUser.salt"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_salt" name="salt"
					value="${testUser.salt}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_registerDate" class="control-label"><s:message code="testUser.registerDate"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_registerDate" name="registerDate"
					value="${testUser.registerDate}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_sex" class="control-label"><s:message code="testUser.sex"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_sex" name="sex"
					value="${testUser.sex}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_email" class="control-label"><s:message code="testUser.email"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_email" name="email"
					value="${testUser.email}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_mobile" class="control-label"><s:message code="testUser.mobile"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_mobile" name="mobile"
					value="${testUser.mobile}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_birthday" class="control-label"><s:message code="testUser.birthday"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_birthday" name="birthday"
					value="${testUser.birthday}" 
					class="input-large required" minlength="1" /> 
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_account" class="control-label"><s:message code="testUser.account"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_account" name="account"
					value="${testUser.account}" 
					class="input-large " />
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_credit" class="control-label"><s:message code="testUser.credit"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_credit" name="credit"
					value="${testUser.credit}" 
					class="input-large " />
				</div>
			</div>
			<div class="control-group">
				<label for="testUser_remark" class="control-label"><s:message code="testUser.remark"/>:</label>
				<div class="controls">
				<input type="text" id="testUser_remark" name="remark"
					value="${testUser.remark}" 
					class="input-large " />
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit"
					value="<s:message code="common.submit"/>" />&nbsp; <input id="cancel_btn" class="btn"
					type="button" value="<s:message code="common.return"/>" onclick="history.back()" />
			</div>
		</fieldset>
	</form>
</body>
</html>

