package com.notifier.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.notifier.common.Constants;
import com.notifier.common.SocketTextHandler;
import com.notifier.models.NotificationInfo;
import com.notifier.models.ResponseInfo;

@Service
public class NotifierService {
	
	@Autowired
	JavaMailSender mailSender;

	public ResponseInfo sendNotification(NotificationInfo nInfo) {
		ResponseInfo response = new ResponseInfo();
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(nInfo.getFrom());
			message.setTo(nInfo.getTo());
			message.setSubject(nInfo.getSubject());
			message.setText(nInfo.getMessage());
		
			mailSender.send(message);
			SocketTextHandler.broadcastAll(nInfo.toJSON().toString());
			response.setStatus(Constants.ResponseCode.SUCCESS);
			response.setStatusMessage("Notification sent successfully");
		}catch (Exception e) {
			e.printStackTrace();
			response.setStatus(Constants.ResponseCode.ERROR);
			response.setStatusMessage("Unable to send notification");
		}
		return response;
	}
}
