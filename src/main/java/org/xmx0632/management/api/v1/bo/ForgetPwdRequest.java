package org.xmx0632.management.api.v1.bo;

import javax.validation.constraints.NotNull;

public class ForgetPwdRequest {

	private String loginName;
	private String email;

	public ForgetPwdRequest() {
	}

	public ForgetPwdRequest(String loginName, String email) {
		this.loginName = loginName;
		this.email = email;
	}

	@NotNull
	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	@NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "ForgetPwdRequest [loginName=" + loginName + ", email=" + email
				+ "]";
	}

}