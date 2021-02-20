package com.notifier.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.notifier.common.CommonUtil;
import com.notifier.common.Constants;
import com.notifier.models.NotificationInfo;
import com.notifier.models.ResponseInfo;
import com.notifier.services.NotifierService;

@RestController
@RequestMapping("/notify")
public class NotifierRestController {

	@Autowired
	NotifierService notifierService;
	
	@RequestMapping("/test")
	public String testService() {
		return "REST Service is running";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseInfo sendNotification(@RequestBody NotificationInfo nInfo) {
		if (null == nInfo.getFrom() || null == nInfo.getTo() || null == nInfo.getSubject() || null == nInfo.getMessage()) {
			return new ResponseInfo(Constants.ResponseCode.INCOMPLETE_REQUEST, "Incomeplete request.");
		} else if ("".equals(nInfo.getFrom().trim()) || "".equals(nInfo.getTo().trim()) || "".equals(nInfo.getSubject().trim())
				|| "".equals(nInfo.getMessage().trim())) {
			return new ResponseInfo(Constants.ResponseCode.INCOMPLETE_REQUEST, "Incomeplete request.");
		}
		
		if(!CommonUtil.validateEmail(nInfo.getFrom()) || !CommonUtil.validateEmail(nInfo.getTo())) {
			return new ResponseInfo(Constants.ResponseCode.INVALID_DATA, "Invalid data.");
		}
		return notifierService.sendNotification(nInfo);
	}
}
