/**
${pojo.getClassJavaDoc(pojo.getDeclarationName() + ".", 0)}
 */
<#include "Ejb3TypeDeclaration.ftl"/>
${pojo.getClassModifiers()} ${pojo.getDeclarationType()} ${pojo.getDeclarationName()} extends ${pojo.importType("org.xmx0632.management.entity.IdEntity")}