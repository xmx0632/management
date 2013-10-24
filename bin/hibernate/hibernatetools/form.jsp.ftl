<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>
<#assign classbody>
<html>
<head>
<title><s:message code="${entityName}"/><s:message code="common.management"/></title>

<script>
	$(document).ready(function() {
		<#foreach field in pojo.getAllPropertiesIterator()>
		<#if pojo.getMetaAttribAsBool(field, "gen-property", true)>
		  <#if field.name = "id">
		  <#else>
			  <#if field_index = 1>
			  <#assign firstField = field.name>
			  <#else>
			  </#if>
		  </#if>
		</#if>
		</#foreach>
		
		//focus on first input element
		${r"$"}("#${entityName}_${firstField}").focus();
		//register validate function for inputForm
		${r"$"}("#inputForm").validate();
	});
</script>
</head>

<body>
	<#assign jdk5 = true>
	<div class="row-fluid sortable">
		<div class="box span12">
			<div class="box-header well" data-original-title>
				<h2><i class="icon-edit"></i> <s:message code="common.management"/><s:message code="${entityName}"/></h2>
				<div class="box-icon">
				</div>
			</div>
			<div class="box-content">
				<form:form id="inputForm" modelAttribute="${entityName}" action="${r"$"}{ctx}/admin/${entityName}/${r"$"}{action}" method="post"
					class="form-horizontal">
					<input type="hidden" name="id" value="${r"$"}{${entityName}.id}" />
					<fieldset>
					<#foreach field in pojo.getAllPropertiesIterator()>
					<#if pojo.getMetaAttribAsBool(field, "gen-property", true)>
					  <#if field.name = "id">
					  <#else>
						  <#if field_index = 1>
						  <#else>
						  </#if>
						  
						<#assign javaTypeName = pojo.getJavaTypeName(field, jdk5)>
						
						<div class="control-group">
							<label for="${entityName}_${field.name}" class="control-label"><s:message code="${entityName}.${field.name}"/>:</label>
							<div class="controls">
							<#if field.name = 'description'>
							<textarea id="${field.name}" name="${field.name}" rows="3" class="input-large">${r"$"}{${entityName}.${field.name}}</textarea>
							<#elseif javaTypeName = 'Date' >
							<input type="text" id="${entityName}_${field.name}" name="${field.name}"
									value="<fmt:formatDate value="${entityName}.${field.name}"
											pattern="yyyy-MM-dd" />"  onClick="WdatePicker()"
									class="Wdate"/>
							<#else>
							<input type="text" id="${entityName}_${field.name}" name="${field.name}"
								value="${r"$"}{${entityName}.${field.name}}" 
								<#assign annColumnAnnotation = pojo.generateAnnColumnAnnotation(field)>
								<#if annColumnAnnotation?contains("nullable=false")>
								class="input-large required" /> 
								<#else>
								class="input-large " />
								</#if>
							</#if>
							</div>
						</div>
					  </#if>
					</#if>
					</#foreach>
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
</#assign>
${classbody}
