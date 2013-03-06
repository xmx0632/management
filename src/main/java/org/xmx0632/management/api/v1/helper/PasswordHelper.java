package org.xmx0632.management.api.v1.helper;

import org.apache.commons.codec.digest.DigestUtils;

public class PasswordHelper {

	public static String md5(String password) {
		return DigestUtils.md5Hex(password);
	}

}
