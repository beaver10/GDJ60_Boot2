package com.iu.base.interceptors;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * 로그인 유무 판별하는 Interceptor
 *
 */


@Slf4j
@Component
public class MemberCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		log.info("==========Member interceptor 실행 ");
		
		HttpSession session = request.getSession();
		
		Object object = session.getAttribute("member");
		if(object!=null) {
			return true;
		}else {
			//redirect
			//response.sendRedirect("/member/login");
			
			//forwarding 형식  
			request.setAttribute("message", "로그인이 필요합니다.");
			request.setAttribute("url", "/member/login");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/result.jsp");
			view.forward(request, response);
			
			return false;
			
		}
		
		
	}
		
	
}
