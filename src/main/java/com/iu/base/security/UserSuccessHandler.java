package com.iu.base.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.iu.base.member.MemberVO;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class UserSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.error("로그인 성공 ======{}=", authentication.getName());
		
		String remember = request.getParameter("remember");
		
		if(remember!=null&&remember.equals("remember")) {
			//MemberVO memberVO = (MemberVO) authentication.getPrincipal();
			Cookie cookie = new Cookie("remember", authentication.getName());
			log.error("쿠킼ㅋ{} ",cookie);
			cookie.setMaxAge(60*60*24); //하루
			response.addCookie(cookie);
			
		}else {
			Cookie[] cookies = request.getCookies();
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("remember")) {
					cookie.setMaxAge(0);
					response.addCookie(cookie);
					break;
				}
			}
			
		}
		
		
		//1. forward 방식
		//RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/");
		//view.forward(request, response);
		
		//2. redirect 방식
		response.sendRedirect("/");
		
	}  

}
