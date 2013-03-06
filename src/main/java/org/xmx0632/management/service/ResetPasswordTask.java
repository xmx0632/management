package org.xmx0632.management.service;

public class ResetPasswordTask {
	private String username;
	private String mail;

	public ResetPasswordTask(String username, String mail) {
		this.username = username;
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "ResetPasswordTask [username=" + username + ", mail=" + mail
				+ "]";
	}

}