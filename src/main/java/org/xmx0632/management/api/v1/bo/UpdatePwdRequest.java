package org.xmx0632.management.api.v1.bo;

public class UpdatePwdRequest {

	private String pwd;

	public UpdatePwdRequest() {
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "UpdatePwdRequest [pwd=" + pwd + "]";
	}

}
