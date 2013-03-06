package org.xmx0632.management.api.v1.helper;

import javax.servlet.ServletRequest;

import org.xmx0632.management.api.v1.Constant;
import org.xmx0632.management.entity.UserAccount;

public class WebHelper {

	public static UserAccount getCurrentUser(ServletRequest request) {
		UserAccount userAccount = (UserAccount) request
				.getAttribute(Constant.CURRENT_USER);
		return userAccount;
	}

}
