package com.iu.base.util;

import java.util.ArrayList;
import java.util.List;

import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.stereotype.Service;

import com.iu.base.member.MemberDAO;
import com.iu.base.member.MemberVO;

@Service
public class MailService {
	
	@Autowired 
	private JavaMailSender javaMailSender;
	
	@Autowired
	private MemberDAO memberDAO;
	
	
	public void sendMail() throws Exception {
		
		//수신 대상을 담을 arraylist 생성 		
		//수신 대상 추가 
		List<MemberVO>list =memberDAO.getMemberBirth();
		List<String> emailList = new ArrayList<>();

		
		for(MemberVO memberVOs : list) {
			emailList.add(memberVOs.getEmail());
//			String[] recipients = new String[emailList.size()];
//			recipients = emailList.toArray(recipients);
			
			//SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
			MimeMessage mimeMailMessage = javaMailSender.createMimeMessage();
			
			//수신자 설정 
			//simpleMailMessage.setTo(recipients);
			mimeMailMessage.addRecipient(RecipientType.TO, new InternetAddress(memberVOs.getEmail()));
			
			//제목 설정 
			//simpleMailMessage.setSubject("비버 홈페이지 가입한 여러분의 생일을 축하합니다.");
			mimeMailMessage.setSubject("비버 홈페이지 가입한 여러분의 생일을 축하합니다."); 
			
			//메일 내용
			mimeMailMessage.setContent("<html><body><h1>생일 축하합니다!</h1></body></html>", "text/html; charset=utf-8");
			
			//메일 발송 
			javaMailSender.send(mimeMailMessage);
		}
		
		
		
		
		
	}
	
	

}
