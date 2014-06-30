package org.xmx0632.management.web.admin;

import com.google.common.collect.Maps;
import java.util.Locale;
import java.util.Map;
import javax.servlet.ServletRequest;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;
import org.xmx0632.management.global.ConfigConstant;
import org.xmx0632.management.service.ConfigService;

import org.xmx0632.management.entity.Permission;
import org.xmx0632.management.service.PermissionService;


@Controller
@RequestMapping(value = "/admin/permission")
public class PermissionController {

	private static Logger log = LoggerFactory.getLogger(PermissionController.class);

	@Autowired
	private ResourceBundleMessageSource messageSource;
	
	private static Map<String, String> sortTypes = null;
	
	private Map<String, String> getSortTypes(Locale locale) {
		if (sortTypes == null) {
			sortTypes = Maps.newLinkedHashMap();

			sortTypes.put("auto",
					messageSource.getMessage("common.auto", null, locale));
			sortTypes.put("name",
					messageSource.getMessage("permission.name", null, locale));
		}
		return sortTypes;
	}

	@Autowired
	private PermissionService permissionService;
	
	@Autowired
	private ConfigService configService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(
				request, "search_");
		Page<Permission> permissions = permissionService.getPermissions(
				searchParams,pageNumber, 
				configService.getIntByName(ConfigConstant.PAGE_SIZE), sortType);
		model.addAttribute("permissions", permissions);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", getSortTypes(request.getLocale()));
		model.addAttribute("searchParams", Servlets
				.encodeParameterStringWithPrefix(searchParams, "search_"));
		
		return "admin/permissionList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("permission", new Permission());
		model.addAttribute("action", "create");
		return "admin/permissionForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid Permission newPermission,
			RedirectAttributes redirectAttributes, ServletRequest request) {
		permissionService.savePermission(newPermission);
		redirectAttributes.addFlashAttribute("message", 
		messageSource.getMessage("common.create.success", new Object[]{"permission"},
						request.getLocale()));
		return "redirect:/admin/permission/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("permission", permissionService.getPermission(id));
		model.addAttribute("action", "update");
		return "admin/permissionForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadPermission") Permission permission,
			RedirectAttributes redirectAttributes, ServletRequest request) {
		permissionService.savePermission(permission);
		redirectAttributes.addFlashAttribute("message", messageSource.getMessage("common.update.success", new Object[]{"permission"},
						request.getLocale()));
		return "redirect:/admin/permission";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes, ServletRequest request) {
		permissionService.deletePermission(id);
		redirectAttributes.addFlashAttribute("message", messageSource.getMessage("common.delete.success", new Object[]{"permission"},
						request.getLocale()));
		return "redirect:/admin/permission";
	}

	/**
	 * implement struts2 preparable by @ModelAttribute, 
	 * query Permission object by id in form,bind content submited in form to the object.
	 */
	@ModelAttribute("preloadPermission")
	public Permission getPermission(
			@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return permissionService.getPermission(id);
		}
		return null;
	}
}

