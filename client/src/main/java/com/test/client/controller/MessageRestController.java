package com.test.client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class MessageRestController {

	@Value("${message:Default message}")
	private String message;

	@RequestMapping("/message")
	String getMessage() {
		return this.message;
	}
}