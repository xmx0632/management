package org.xmx0632.management.api.v1.bo;

public class RegisterRequest {

	private String email;
	private String username;
	private String pwd;

	public RegisterRequest() {
	}

	public RegisterRequest(String email, String username, String plainPassword) {
		this.email = email;
		this.username = username;
		this.pwd = plainPassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "RegisterRequest [email=" + email + ", username=" + username
				+ ", pwd=" + pwd + "]";
	}

}
