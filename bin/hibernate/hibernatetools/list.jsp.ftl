<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/common/taglibs.jsp" %>

<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>

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

<#assign classbody>
<html>
<head>
<title>
<s:message code="${entityName}"/><s:message code="common.management"/>
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
						<label><s:message code="${entityName}.${firstField}"/>:</label> <input type="text" name="search_LIKE_${firstField}"
							class="input-medium" value="${r"$"}{param.search_LIKE_${firstField}}">
						<button type="submit" class="btn"><s:message code="common.search"/></button>
					</form>
				</div>
				<tags:sort />
			
				<table id="contentTable"
					class="table table-striped table-bordered table-condensed">
				<#assign jdk5 = true>
					<thead>
						<tr>
							<#foreach field in pojo.getAllPropertiesIterator()>
							<#if pojo.getMetaAttribAsBool(field, "gen-property", true)>
								<#if field.name = "id">
								<#else>
							<th><s:message code="${entityName}.${field.name}"/></th>
								</#if>
							</#if>
							</#foreach>
							<th><s:message code="common.management"/></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${r"$"}{${entityName}s.content}" var="${entityName}">
							<tr>
							<#foreach field in pojo.getAllPropertiesIterator()>
							<#if pojo.getMetaAttribAsBool(field, "gen-property", true)>
							  <#if field.name = "id">
							  <#else>
								  <#if field_index = 1>
							    <td><a href="${r"$"}{ctx}/admin/${entityName}/update/${r"$"}{${entityName}.id}">${r"$"}{${entityName}.${field.name}}</a></td>
								  <#else>
									<#assign annColumnAnnotation = pojo.generateAnnColumnAnnotation(field)>
									<#assign javaTypeName = pojo.getJavaTypeName(field, jdk5)>
									<#if javaTypeName = 'Date' >
								<td><fmt:formatDate value="${r"$"}{${entityName}.${field.name}}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
									<#else>
							    <td><tags:trimString value="${r"$"}{${entityName}.${field.name}}" maxLength="11" /></td>
									</#if>
								  </#if>
							  </#if>
							</#if>
							</#foreach>
								<td><a class="btn btn-danger" href="${r"$"}{ctx}/admin/${entityName}/delete/${r"$"}{${entityName}.id}"><i class="icon-trash icon-white"></i><s:message code="common.delete"/></a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<tags:pagination page="${r"$"}{${entityName}s}" paginationSize="5" />
			</div>
		</div>
	</div>

	<div>
		<a class="btn" href="${r"$"}{ctx}/admin/${entityName}/create"><s:message code="common.create"/><s:message code="${entityName}"/></a>
	</div>
</body>
</html>
</#assign>
${classbody}