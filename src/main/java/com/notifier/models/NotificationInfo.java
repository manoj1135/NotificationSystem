package com.notifier.models;

import org.json.JSONObject;

public class NotificationInfo {
	private String from;
	private String to;
	private String subject;
	private String message;
	private String status;
	
	public NotificationInfo() {}

	public NotificationInfo(String from, String to, String subject, String message, String status) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.message = message;
		this.status = status;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NotificationInfo [from=" + from + ", to=" + to + ", subject=" + subject + ", message=" + message + ", status="+status+" ]";
	}
	
	public JSONObject toJSON() {
		JSONObject obj = new JSONObject();
		obj.put("from", from);
		obj.put("to", to);
		obj.put("subject", subject);
		obj.put("message", message);
		return obj;
	}
	
}
