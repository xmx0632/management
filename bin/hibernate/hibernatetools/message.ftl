
<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>
<#assign classbody>
#=== ${entityName} message ===
${entityName} = ${declarationName}
<#foreach field in pojo.getAllPropertiesIterator()>
<#if pojo.getMetaAttribAsBool(field, "gen-property", true)>
  <#if field.name = "id">
  <#else>
${entityName}.${field.name} = ${field.name?cap_first}
  </#if>
</#if>
</#foreach>
</#assign>
${classbody}
