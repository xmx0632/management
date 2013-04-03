package org.xmx0632.management.web.account;

import java.util.Date;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.xmx0632.management.entity.UserAccount;
import org.xmx0632.management.service.UserAccountService;

/**
 * show Dashboard info
 * 
 * @author xmx0632
 * 
 */
@Controller
@RequestMapping(value = "/dashboard")
public class DashboardController {
	private static Logger log = LoggerFactory
			.getLogger(DashboardController.class);

	@Autowired
	private UserAccountService userAccountService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String welcome(Model model) {

		// 当前总用户数
		long totalUserCount = userAccountService.getUserCount();

		// 手机平台用户数
		long mobileUserCount = userAccountService
				.countByPlatform(UserAccount.PLATFORM_MOBILE);

		DateTime yestoday = new DateTime().minusDays(1);
		Date startTime = yestoday.withTimeAtStartOfDay().toDate();
		Date endTime = DateTime.now().toDate();
		log.debug("startTime:{},endTime:{}", startTime, endTime);

		// 最近一天注册的手机用户数
		long lastestRegisterMobileUserCount = userAccountService
				.countByPlatformAndCreateTime(startTime, endTime,
						UserAccount.PLATFORM_MOBILE);

		model.addAttribute("totalUserCount", totalUserCount);
		model.addAttribute("mobileUserCount", mobileUserCount);
		model.addAttribute("lastestRegisterMobileUserCount",
				lastestRegisterMobileUserCount);

		log.debug("totalUserCount:{}", totalUserCount);
		log.debug("mobileUserCount:{}", mobileUserCount);
		log.debug("lastestRegisterMobileUserCount:{}",
				lastestRegisterMobileUserCount);

		return "account/dashboard";
	}
}
