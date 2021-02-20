package com.notifier.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class NotifierController {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
}
