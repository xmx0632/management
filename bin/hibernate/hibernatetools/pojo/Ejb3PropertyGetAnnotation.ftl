<#if ejb3>
<#if pojo.hasIdentifierProperty()>
<#if property.equals(clazz.identifierProperty)>
 ${pojo.generateAnnIdGenerator()}
<#-- if this is the id property (getter)-->
<#-- explicitly set the column name for this property-->
</#if>
</#if>
<#if c2h.isManyToOne(property)>
<#--TODO support @OneToOne true and false-->    
${pojo.generateManyToOneAnnotation(property)}
<#--TODO support optional and targetEntity-->    
${pojo.generateJoinColumnsAnnotation(property, cfg)}
<#elseif c2h.isCollection(property)>
${pojo.generateCollectionAnnotation(property, cfg)}
<#else>
<#--${pojo.generateBasicAnnotation(property)}-->
<#--${pojo.generateAnnColumnAnnotation(property)}-->

<#--add hibernate validation annotation,auto add @NotBlank if column is not null-->
<#assign annColumnAnnotation = pojo.generateAnnColumnAnnotation(property)>
<#if annColumnAnnotation?contains("nullable")>    @${pojo.importType("javax.validation.constraints.NotNull")}</#if>
</#if>
<#--${pojo.generateAnnColumnAnnotation(property)}-->
</#if>