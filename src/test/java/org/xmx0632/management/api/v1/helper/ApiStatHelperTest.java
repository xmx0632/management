package org.xmx0632.management.api.v1.helper;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.xmx0632.management.api.v1.helper.ApiStatHelper;

public class ApiStatHelperTest {

	@Test
	public void testGetShortMethodName() {
		String fullName = "org.xmx0632.management.api.v1.UserAccountApiController.login(javax.servlet.ServletRequest)";

		assertEquals("UserAccountApiController.login",
				ApiStatHelper.getShortMethodName(fullName));
	}

}
