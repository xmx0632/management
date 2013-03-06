<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<html>
<head>
<title>config<s:message code="common.management"/></title>

<script>
	$(document).ready(function() {
		
		//聚焦第一个输入框
		$("#config_name").focus();
		//为inputForm注册validate函数
		$("#inputForm").validate();
	});
</script>
</head>

<body>
	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-edit"></i> <s:message code="common.management"/><s:message code="config"/></h2>
				<div class="box-icon">
				</div>
			</div>
			<div class="box-content">
				<form:form id="inputForm" modelAttribute="config" action="${ctx}/admin/config/${action}" method="post"
					class="form-horizontal">
					<input type="hidden" name="id" value="${config.id}" />
				  	<fieldset>
						<div class="control-group">
							<label for="config_name" class="control-label"><s:message code="config.name"/>:</label>
							<div class="controls">
							<input type="text" id="config_name" name="name"
								value="${config.name}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="config_configValue" class="control-label"><s:message code="config.configValue"/>:</label>
							<div class="controls">
							<input type="text" id="config_configValue" name="configValue"
								value="${config.configValue}" 
								class="input-large required" /> 
							</div>
						</div>
						<div class="control-group">
							<label for="config_description" class="control-label"><s:message code="config.description"/>:</label>
							<div class="controls">
							<textarea id="description" name="description" rows="3" class="input-large">${config.description}</textarea>
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