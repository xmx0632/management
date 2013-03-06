package org.xmx0632.management.web.admin;

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
import org.xmx0632.management.entity.Config;
import org.xmx0632.management.global.ConfigConstant;
import org.xmx0632.management.service.ConfigService;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/admin/config")
public class ConfigController {

	private static Logger log = LoggerFactory.getLogger(ConfigController.class);

	@Autowired
	private ResourceBundleMessageSource messageSource;

	private static Map<String, String> sortTypes = null;

	private Map<String, String> getSortTypes(Locale locale) {
		if (sortTypes == null) {
			sortTypes = Maps.newLinkedHashMap();

			sortTypes.put("auto",
					messageSource.getMessage("common.auto", null, locale));
			sortTypes.put("name",
					messageSource.getMessage("config.name", null, locale));
		}
		return sortTypes;
	}

	@Autowired
	private ConfigService configService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(
				request, "search_");
		Page<Config> configs = configService.getConfigs(searchParams,
				pageNumber,
				configService.getIntByName(ConfigConstant.PAGE_SIZE), sortType);
		model.addAttribute("configs", configs);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", getSortTypes(request.getLocale()));
		model.addAttribute("searchParams", Servlets
				.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "admin/configList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		model.addAttribute("config", new Config());
		model.addAttribute("action", "create");
		return "admin/configForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid Config newConfig,
			RedirectAttributes redirectAttributes) {
		configService.saveConfig(newConfig);
		redirectAttributes.addFlashAttribute("message", "创建config成功");
		return "redirect:/admin/config/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		model.addAttribute("config", configService.getConfig(id));
		model.addAttribute("action", "update");
		return "admin/configForm";
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(@Valid @ModelAttribute("preloadConfig") Config config,
			RedirectAttributes redirectAttributes) {
		configService.saveConfig(config);
		redirectAttributes.addFlashAttribute("message", "更新config成功");
		return "redirect:/admin/config";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		configService.deleteConfig(id);
		redirectAttributes.addFlashAttribute("message", "删除config成功");
		return "redirect:/admin/config";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2
	 * Preparable二次部分绑定的效果,先根据form的id从数据库查出Config对象,再把Form提交的内容绑定到该对象上.
	 * 因为仅update()方法的form中有id属性,因此本方法在该方法中执行.
	 */
	@ModelAttribute("preloadConfig")
	public Config getConfig(
			@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return configService.getConfig(id);
		}
		return null;
	}
}
