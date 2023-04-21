package com.iu.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.iu.base.interceptors.AdminCheckInterceptor;
import com.iu.base.interceptors.MemberCheckInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Autowired
	private MemberCheckInterceptor memberCheckInterceptor;
	
	@Autowired
	private AdminCheckInterceptor adminCheckInterceptor;
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//인터셉터 순서 맞춰야함 
		//로그인 했는지, 그 이후에 권한이 있는지 등...
		
		registry.addInterceptor(memberCheckInterceptor)
				.addPathPatterns("/member/mypage")
				.addPathPatterns("/member/admin")
				.addPathPatterns("/qna/*")
				.excludePathPatterns("/qna/list")
				.addPathPatterns("/notice/*")
				.excludePathPatterns("/notice/list")
				.excludePathPatterns("/notice/detail");
		
		registry.addInterceptor(adminCheckInterceptor)
				.addPathPatterns("/member/admin")
				.addPathPatterns("/notice/*")
				.excludePathPatterns("/notice/list")
				.excludePathPatterns("/notice/detail");
		
	}
	
}
