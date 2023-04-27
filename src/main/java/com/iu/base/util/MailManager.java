package com.iu.base.util;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


@Component
public class MailManager {

	@Value("${spring.mail.username}")
	private String sender;
	
	@Autowired
	private JavaMailSender javaMailSender;
	
	public void send(String to, String sub, String con) throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		mimeMessage.setFrom(sender);
		mimeMessage.addRecipient(RecipientType.TO, new InternetAddress(to));
		mimeMessage.setSubject(sub);
		mimeMessage.setText(con,"utf-8", "html");
		javaMailSender.send(mimeMessage);
		
		
		//HTML태그를 무시하고 그대로 Text로 보내는 것 
//		SimpleMailMessage mailMessage = new SimpleMailMessage();
//		mailMessage.setFrom(sender);
//		mailMessage.setTo(to);
//		mailMessage.setSubject(sub);
//		mailMessage.setText(con);
//		javaMailSender.send(mailMessage);
	}
}
