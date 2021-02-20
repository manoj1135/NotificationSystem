package com.notifier.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = { "request" })
public class ResponseInfo {
	
	private NotificationInfo request;
	private String status;
	private String statusMessage;
	public ResponseInfo() {}
	public ResponseInfo(String status, String statusMessage) {
		this.status = status;
		this.statusMessage = statusMessage;
	}
	public ResponseInfo(NotificationInfo request, String status, String statusMessage) {
		this.request = request;
		this.status = status;
		this.statusMessage = statusMessage;
	}
	
	public NotificationInfo getRequest() {
		return request;
	}
	public void setRequest(NotificationInfo request) {
		this.request = request;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusMessage() {
		return statusMessage;
	}
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}
	
	@Override
	public String toString() {
		return "ResponseInfo [request=" + request.toString() + ", status=" + status + ", statusMessage=" + statusMessage + "]";
	}
}
