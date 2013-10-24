<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>
<#-- 修改包名为:package ${配置的包名}.repository; -->
${pojo.getPackageDeclaration()?replace(";", ".repository;")}

<#assign classbody>

public interface ${declarationName}Dao extends ${pojo.importType("org.springframework.data.repository.PagingAndSortingRepository")}<${declarationName}, ${pojo.getJavaTypeName(clazz.identifierProperty, true)}>,
	${pojo.importType("org.springframework.data.jpa.repository.JpaSpecificationExecutor")}<${declarationName}> {
}
</#assign>

${pojo.generateImports()}
<#-- import对应的entity-->
<#assign qualifiedDeclarationName = pojo.importType(pojo.getPackageName())>
import ${pojo.getPackageName()}.entity.${declarationName};
${classbody}
