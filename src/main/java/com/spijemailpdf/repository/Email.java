package com.spijemailpdf.repository;

public class Email {

	private String toEmail;
	private String fromName;
	private String subject;
	private String html;
	private String content;
	
	public String gettoEmail() {
		return toEmail;
	}
	public void setEmail(String email) {
		this.toEmail = email;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Email [toEmail=" + toEmail + ", content=" + content + ", subject=" + subject + "]";
	}
	public String getFromName() {
		return fromName;
	}
	public void setFromName(String fromName) {
		this.fromName = fromName;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	
	
}
