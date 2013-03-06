package org.xmx0632.management.api.v1.helper;

public class ApiStatHelper {

	String fullName = "org.xmx0632.management.api.v1."
			+ "UserAccountApiController.login(javax.servlet.ServletRequest)";

	public static String getShortMethodName(String fullName) {
		int openBracketIdx = fullName.indexOf("(");
		String methodNameWithoutParam = fullName.substring(0, openBracketIdx);
		String[] arrays = methodNameWithoutParam.split("\\.");
		int length = arrays.length;
		return arrays[length - 2] + "." + arrays[length - 1];
	}
}
