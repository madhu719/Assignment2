package com.terra.example;

public interface MailService {
	String sendSimpleMail(MailDetails details);

	String sendMailWithAttachment(MailDetails details);
}
