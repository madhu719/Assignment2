package com.terra.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class MailController {
	@Autowired
	private MailService emailService;

	@PostMapping("/sendMail")
	public String sendMail(@RequestBody MailDetails details) {
		String status = emailService.sendSimpleMail(details);
		return status;
	}

	@PostMapping("/sendMailWithAttachment")
	public String sendMailWithAttachment(@RequestBody MailDetails details) {
		String status = emailService.sendMailWithAttachment(details);
		return status;
	}
}
