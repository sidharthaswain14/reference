package com.fyd.util.mail.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.fyd.util.mail.beans.MailMessage;

@Component
public class NotificationManagerImpl implements NotificationManager {

	@Autowired
	private JavaMailSender javaMailSender;

	@Override
	public void send(MailMessage mailMessage) {
		  SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		  
		  simpleMailMessage.setFrom(mailMessage.getFrom());
		  simpleMailMessage.setTo(mailMessage.getTo());
		  simpleMailMessage.setSubject(mailMessage.getSubject());
		  simpleMailMessage.setText(mailMessage.getBody());
		  
		  javaMailSender.send(simpleMailMessage); 
	}
}
