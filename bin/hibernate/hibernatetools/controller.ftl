<#assign declarationName = pojo.importType(pojo.getDeclarationName())>
<#assign entityName = declarationName?uncap_first>
${pojo.getPackageDeclaration()?replace(";", ".web.admin;")}
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

@${pojo.importType("org.springframework.stereotype.Controller")}
@${pojo.importType("org.springframework.web.bind.annotation.RequestMapping")}(value = "/admin/${entityName}")
public class ${declarationName}Controller {

	private static ${pojo.importType("org.slf4j.Logger")} log = ${pojo.importType("org.slf4j.LoggerFactory")}.getLogger(${declarationName}Controller.class);

	@Autowired
	private ${pojo.importType("org.springframework.context.support.ResourceBundleMessageSource")} messageSource;
	
	private static ${pojo.importType("java.util.Map")}<String, String> sortTypes = null;
	
	private Map<String, String> getSortTypes(${pojo.importType("java.util.Locale")} locale) {
		if (sortTypes == null) {
			sortTypes = ${pojo.importType("com.google.common.collect.Maps")}.newLinkedHashMap();

			sortTypes.put("auto",
					messageSource.getMessage("common.auto", null, locale));
			sortTypes.put("${firstField}",
					messageSource.getMessage("${entityName}.${firstField}", null, locale));
		}
		return sortTypes;
	}

	@${pojo.importType("org.springframework.beans.factory.annotation.Autowired")}
	private ${declarationName}Service ${entityName}Service;
	
	@Autowired
	private ${pojo.importType("org.xmx0632.management.service.ConfigService")} configService;
	
	@${pojo.importType("org.springframework.web.bind.annotation.RequestMapping")}(method = ${pojo.importType("org.springframework.web.bind.annotation.RequestMethod")}.GET)
	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			${pojo.importType("org.springframework.ui.Model")} model, ${pojo.importType("javax.servlet.ServletRequest")} request) {
		Map<String, Object> searchParams = ${pojo.importType("org.springside.modules.web.Servlets")}.getParametersStartingWith(
				request, "search_");
		${pojo.importType("org.springframework.data.domain.Page")}<${declarationName}> ${entityName}s = ${entityName}Service.get${declarationName}s(
				searchParams,pageNumber, 
				configService.getIntByName(${pojo.importType("org.xmx0632.management.global.ConfigConstant")}.PAGE_SIZE), sortType);
		model.addAttribute("${entityName}s", ${entityName}s);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", getSortTypes(request.getLocale()));
		model.addAttribute("searchParams", ${pojo.importType("org.springside.modules.web.Servlets")}
				.encodeParameterStringWithPrefix(searchParams, "search_"));
		
		return "admin/${entityName}List";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("${entityName}", new ${declarationName}());
		model.addAttribute("action", "create");
		return "admin/${entityName}Form";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid ${declarationName} new${declarationName},
			RedirectAttributes redirectAttributes, ServletRequest request) {
		${entityName}Service.save${declarationName}(new${declarationName});
		redirectAttributes.addFlashAttribute("message", 
		messageSource.getMessage("common.create.success", new Object[]{"${entityName}"},
						request.getLocale()));
		return "redirect:/admin/${entityName}/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@${pojo.importType("org.springframework.web.bind.annotation.PathVariable")}("id") Long id, Model model) {
		model.addAttribute("${entityName}", ${entityName}Service.get${declarationName}(id));
		model.addAttribute("action", "update");
		return "admin/${entityName}Form";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@${pojo.importType("javax.validation.Valid")} @${pojo.importType("org.springframework.web.bind.annotation.ModelAttribute")}("preload${declarationName}") ${declarationName} ${entityName},
			${pojo.importType("org.springframework.web.servlet.mvc.support.RedirectAttributes")} redirectAttributes, ServletRequest request) {
		${entityName}Service.save${declarationName}(${entityName});
		redirectAttributes.addFlashAttribute("message", messageSource.getMessage("common.update.success", new Object[]{"${entityName}"},
						request.getLocale()));
		return "redirect:/admin/${entityName}";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes, ServletRequest request) {
		${entityName}Service.delete${declarationName}(id);
		redirectAttributes.addFlashAttribute("message", messageSource.getMessage("common.delete.success", new Object[]{"${entityName}"},
						request.getLocale()));
		return "redirect:/admin/${entityName}";
	}

	/**
	 * implement struts2 preparable by @ModelAttribute, 
	 * query ${declarationName} object by id in form,bind content submited in form to the object.
	 */
	@ModelAttribute("preload${declarationName}")
	public ${declarationName} get${declarationName}(
			@${pojo.importType("org.springframework.web.bind.annotation.RequestParam")}(value = "id", required = false) Long id) {
		if (id != null) {
			return ${entityName}Service.get${declarationName}(id);
		}
		return null;
	}
}
</#assign>

${pojo.generateImports()}
<#-- import对应的entity-->
<#assign qualifiedDeclarationName = pojo.importType(pojo.getPackageName())>
import ${pojo.getPackageName()}.entity.${declarationName};
import ${pojo.getPackageName()}.service.${declarationName}Service;

${classbody}
