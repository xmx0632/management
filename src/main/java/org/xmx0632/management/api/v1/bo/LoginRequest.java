package org.xmx0632.management.api.v1.bo;

public class LoginRequest {

	private String loginName;

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@Override
	public String toString() {
		return "LoginRequest [loginName=" + loginName + "]";
	}

}