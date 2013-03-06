package org.xmx0632.management.api.v1.bo;

import java.math.BigDecimal;

public class MobileUser {

	private String customerId;
	private String customerName;
	private String sex;
	private String mobile;
	private String email;
	private String username;
	private BigDecimal account;
	private Integer credit;
	private boolean enableChangePwd = false;

	public MobileUser() {
	}

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getAccount() {
		return this.account;
	}

	public void setAccount(BigDecimal account) {
		this.account = account;
	}

	public Integer getCredit() {
		return this.credit;
	}

	public void setCredit(Integer credit) {
		this.credit = credit;
	}

	public boolean isEnableChangePwd() {
		return enableChangePwd;
	}

	public void setEnableChangePwd(boolean enableChangePwd) {
		this.enableChangePwd = enableChangePwd;
	}

	@Override
	public String toString() {
		return "UserAccountDTO [customerId=" + customerId + ", customerName="
				+ customerName + ", sex=" + sex + ", mobile=" + mobile
				+ ", email=" + email + ", username=" + username + ", credit="
				+ credit + "]";
	}
}
