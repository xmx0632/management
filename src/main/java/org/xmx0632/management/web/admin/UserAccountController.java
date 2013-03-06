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
import org.xmx0632.management.entity.UserAccount;
import org.xmx0632.management.global.ConfigConstant;
import org.xmx0632.management.service.ConfigService;
import org.xmx0632.management.service.UserAccountService;

import com.google.common.collect.Maps;

@Controller
@RequestMapping(value = "/admin/userAccount")
public class UserAccountController {

	private static Logger log = LoggerFactory
			.getLogger(UserAccountController.class);

	private static Map<String, String> allGender = Maps.newHashMap();
	private static Map<String, String> allPlatform = Maps.newHashMap();
	private static Map<String, String> allStatus = Maps.newHashMap();

	static {
		allGender.put(UserAccount.FEMALE, "女");
		allGender.put(UserAccount.MALE, "男");

		allPlatform.put(UserAccount.PLATFORM_ERP, "ERP平台");
		allPlatform.put(UserAccount.PLATFORM_MOBILE, "手机平台");

		allStatus.put(UserAccount.STATUS_NORMAL, "正常");
		allStatus.put(UserAccount.STATUS_ABNORMAL, "冻结");
	}

	@Autowired
	private ResourceBundleMessageSource messageSource;

	private static Map<String, String> sortTypes = null;

	private Map<String, String> getSortTypes(Locale locale) {
		if (sortTypes == null) {
			sortTypes = Maps.newLinkedHashMap();

			sortTypes.put("auto",
					messageSource.getMessage("common.auto", null, locale));
			sortTypes.put("customerId", messageSource.getMessage(
					"userAccount.customerId", null, locale));
			sortTypes.put("registerDate", messageSource.getMessage(
					"userAccount.registerDate", null, locale));
		}
		return sortTypes;
	}

	@Autowired
	private UserAccountService userAccountService;

	@Autowired
	private ConfigService configService;

	@RequestMapping(method = RequestMethod.GET)
	public String list(
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType,
			@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			Model model, ServletRequest request) {
		Map<String, Object> searchParams = Servlets.getParametersStartingWith(
				request, "search_");
		Page<UserAccount> userAccounts = userAccountService.getUserAccounts(
				searchParams, pageNumber,
				configService.getIntByName(ConfigConstant.PAGE_SIZE), sortType);
		initListElement(model);
		model.addAttribute("userAccounts", userAccounts);
		model.addAttribute("sortType", sortType);
		model.addAttribute("sortTypes", getSortTypes(request.getLocale()));
		model.addAttribute("searchParams", Servlets
				.encodeParameterStringWithPrefix(searchParams, "search_"));

		return "admin/userAccountList";
	}

	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String createForm(Model model) {
		initListElement(model);
		model.addAttribute("userAccount", new UserAccount());
		model.addAttribute("action", "create");
		return "admin/userAccountForm";
	}

	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String create(@Valid UserAccount newUserAccount,
			RedirectAttributes redirectAttributes) {
		userAccountService.saveUserAccount(newUserAccount);
		redirectAttributes.addFlashAttribute("message", "创建userAccount成功");
		return "redirect:/admin/userAccount/";
	}

	@RequestMapping(value = "update/{id}", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, Model model) {
		initListElement(model);
		model.addAttribute("userAccount", userAccountService.getUserAccount(id));
		model.addAttribute("action", "update");
		return "admin/userAccountForm";
	}

	private void initListElement(Model model) {
		model.addAttribute("allGender", allGender);
		model.addAttribute("allPlatform", allPlatform);
		model.addAttribute("allStatus", allStatus);
	}

	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(
			@Valid @ModelAttribute("preloadUserAccount") UserAccount userAccount,
			RedirectAttributes redirectAttributes) {
		userAccountService.saveUserAccount(userAccount);
		redirectAttributes.addFlashAttribute("message", "更新userAccount成功");
		return "redirect:/admin/userAccount";
	}

	@RequestMapping(value = "delete/{id}")
	public String delete(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		userAccountService.deleteUserAccount(id);
		redirectAttributes.addFlashAttribute("message", "删除userAccount成功");
		return "redirect:/admin/userAccount";
	}

	@RequestMapping(value = "ban/{id}")
	public String ban(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		userAccountService.changeStatusBy(id, UserAccount.STATUS_ABNORMAL);
		redirectAttributes.addFlashAttribute("message", "冻结userAccount成功");
		return "redirect:/admin/userAccount";
	}

	@RequestMapping(value = "unban/{id}")
	public String unban(@PathVariable("id") Long id,
			RedirectAttributes redirectAttributes) {
		userAccountService.changeStatusBy(id, UserAccount.STATUS_NORMAL);
		redirectAttributes.addFlashAttribute("message", "解除冻结userAccount成功");
		return "redirect:/admin/userAccount";
	}

	/**
	 * 使用@ModelAttribute, 实现Struts2
	 * Preparable二次部分绑定的效果,先根据form的id从数据库查出UserAccount对象,再把Form提交的内容绑定到该对象上.
	 * 因为仅update()方法的form中有id属性,因此本方法在该方法中执行.
	 */
	@ModelAttribute("preloadUserAccount")
	public UserAccount getUserAccount(
			@RequestParam(value = "id", required = false) Long id) {
		if (id != null) {
			return userAccountService.getUserAccount(id);
		}
		return null;
	}
}
