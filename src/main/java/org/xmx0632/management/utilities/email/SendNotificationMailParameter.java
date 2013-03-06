package org.xmx0632.management.utilities.email;

public class SendNotificationMailParameter {
	private String userName;
	private String resetUrl;
	private String to;
	private String from;
	private String subject;

	public SendNotificationMailParameter(String userName, String resetUrl,
			String to, String from, String subject) {
		this.userName = userName;
		this.resetUrl = resetUrl;
		this.to = to;
		this.from = from;
		this.subject = subject;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getResetUrl() {
		return resetUrl;
	}

	public void setResetUrl(String resetUrl) {
		this.resetUrl = resetUrl;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}