package com.iu.base.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import com.iu.base.member.MemberDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class UserLogoutSuccessHandler implements LogoutSuccessHandler {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String restKey;
		
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		log.error("로그아웃 =============={}",memberDAO);
		//response.sendRedirect("/");
		response.sendRedirect("https://kauth.kakao.com/oauth/logout?client_id="+restKey+"&logout_redirect_uri=http://ec2-13-209-65-155.ap-northeast-2.compute.amazonaws.com/");
		
	}
	
	

}
