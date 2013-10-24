<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>
${pojo.getPackageDeclaration()?replace(";", ".service;")}
<#assign classbody>
@${pojo.importType("org.springframework.stereotype.Component")}
// all public method will be managed by transaction as default.
@${pojo.importType("org.springframework.transaction.annotation.Transactional")}(readOnly = true)
public class ${declarationName}Service {

	private static ${pojo.importType("org.slf4j.Logger")} log = ${pojo.importType("org.slf4j.LoggerFactory")}.getLogger(${declarationName}Service.class);
	
	private ${declarationName}Dao ${entityName}Dao;

	public ${declarationName} get${declarationName}(${pojo.getJavaTypeName(clazz.identifierProperty, true)} id) {
		return ${entityName}Dao.findOne(id);
	}

	public ${pojo.importType("java.util.List")}<${declarationName}> getAll${declarationName}() {
		return (${pojo.importType("java.util.List")}<${declarationName}>)${entityName}Dao.findAll();
	}
	
	@Transactional(readOnly = false)
	public void save${declarationName}(${declarationName} entity) {
		${entityName}Dao.save(entity);
	}

	@Transactional(readOnly = false)
	public void delete${declarationName}(${pojo.getJavaTypeName(clazz.identifierProperty, true)} id) {
		${entityName}Dao.delete(id);
	}

	public ${pojo.importType("org.springframework.data.domain.Page")}<${declarationName}> get${declarationName}s(${pojo.importType("java.util.Map")}<String, Object> filterParams,
			int pageNumber, int pageSize, String sortType) {
		${pojo.importType("org.springframework.data.domain.PageRequest")} pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		${pojo.importType("org.springframework.data.jpa.domain.Specification")}<${declarationName}> spec = buildSpecification(filterParams);
		
		return ${entityName}Dao.findAll(spec, pageRequest);
	}
	

	/**
	 * create pagination request.
	 */
	private ${pojo.importType("org.springframework.data.domain.PageRequest")} buildPageRequest(int pageNumber, int pagzSize, String sortType) {
		${pojo.importType("org.springframework.data.domain.Sort")} sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(${pojo.importType("org.springframework.data.domain.Sort.Direction")}.DESC, "id");
		} 
		/*
		else if ("title".equals(sortType)) {
			sort = new Sort(Direction.ASC, "title");
		}
		*/

		return new PageRequest(pageNumber - 1, pagzSize, sort);
	}
	
	/**
	 * create dynamic query criteria.
	 */
	private ${pojo.importType("org.springframework.data.jpa.domain.Specification")}<${declarationName}> buildSpecification(Map<String, Object> filterParams) {
		Map<String, ${pojo.importType("org.springside.modules.persistence.SearchFilter")}> filters = SearchFilter.parse(filterParams);
		// filters.put("user.id", new SearchFilter("user.id", Operator.EQ, userId));
		Specification<${declarationName}> spec = ${pojo.importType("org.springside.modules.persistence.DynamicSpecifications")}.bySearchFilter(filters.values(), ${declarationName}.class);
		return spec;
	}
	
	// -----------------//
	// Setter methods   //
	// -----------------//
	
	@${pojo.importType("org.springframework.beans.factory.annotation.Autowired")}(required = true)
	public void set${declarationName}Dao(${declarationName}Dao ${entityName}Dao) {
		this.${entityName}Dao = ${entityName}Dao;
	}
}
</#assign>

${pojo.generateImports()}
import ${pojo.getPackageName()}.entity.${declarationName};
import ${pojo.getPackageName()}.repository.${declarationName}Dao;

${classbody}
