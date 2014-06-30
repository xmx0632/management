<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<html>
<head>
<title><s:message code="permission"/><s:message code="common.management"/></title>

<script>
	$(document).ready(function() {
		
		//focus on first input element
		$("#permission_name").focus();
		//register validate function for inputForm
		$("#inputForm").validate();
	});
</script>
</head>

<body>
	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-edit"></i> <s:message code="common.management"/><s:message code="permission"/></h2>
				<div class="box-icon">
				</div>
			</div>
			<div class="box-content">
				<form:form id="inputForm" modelAttribute="permission" action="${ctx}/admin/permission/${action}" method="post"
					class="form-horizontal">
					<input type="hidden" name="id" value="${permission.id}" />
					<fieldset>
						  
						
						<div class="control-group">
							<label for="permission_name" class="control-label"><s:message code="permission.name"/>:</label>
							<div class="controls">
							<input type="text" id="permission_name" name="name"
								value="${permission.name}" 
								class="input-large required" /> 
							</div>
						</div>
						  
						
						<div class="control-group">
							<label for="permission_description" class="control-label"><s:message code="permission.description"/>:</label>
							<div class="controls">
							<textarea id="description" name="description" rows="3" class="input-large">${permission.description}</textarea>
							</div>
						</div>
						  
						
						<div class="control-group">
							<label for="permission_permissionString" class="control-label"><s:message code="permission.permissionString"/>:</label>
							<div class="controls">
							<input type="text" id="permission_permissionString" name="permissionString"
								value="${permission.permissionString}" 
								class="input-large " />
							</div>
						</div>
						<div class="form-actions">
							<input id="submit_btn" class="btn btn-primary" type="submit"
								value="<s:message code="common.submit"/>" />&nbsp; <input id="cancel_btn" class="btn"
								type="button" value="<s:message code="common.return"/>" onclick="history.back()" />
						</div>
					</fieldset>
				</form:form>
			</div>
		</div><!--/span-->
	</div><!--/row-->
</body>
</html>

