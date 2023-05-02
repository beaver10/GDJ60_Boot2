package com.iu.base.config;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.iu.base.member.MemberService;
import com.iu.base.member.MemberSocialService;
import com.iu.base.security.UserLoginFailHandler;
import com.iu.base.security.UserLogoutHandler;
import com.iu.base.security.UserLogoutSuccessHandler;
import com.iu.base.security.UserSuccessHandler;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserSuccessHandler userSuccessHandler;
	
	@Autowired
	private UserLogoutSuccessHandler userLogoutSuccessHandler;
	
	@Autowired
	private MemberSocialService memberSocialService;
	
	@Autowired
	private UserLogoutHandler userLogoutHandler;

	@Bean
	WebSecurityCustomizer webSecurityConfig() {
		
		//Security에서 무시해야하는 URL 패턴 등록
		return web -> web
			   .ignoring()
			   .antMatchers("/images/**")
			   .antMatchers("/css/**")
			   .antMatchers("/js/**")
//			   .antMatchers("/assets/**")
			   .antMatchers("/resources/**")
			   
			   
			   
			   ;
	}
	
	@Bean
	SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception{
		httpSecurity
				.cors()
				.and()
				.csrf()
				.disable()
			.authorizeRequests()
				//URL과 권한 매칭 
				.antMatchers("/").permitAll()
				.antMatchers("/member/join").permitAll()
				.antMatchers("/notice/add").hasRole("MEMBER")
				.antMatchers("/notice/update").hasRole("ADMIN")
				.antMatchers("/notice/delete").hasRole("ADMIN")
				.antMatchers("/notice/*").permitAll()
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/qna/add").hasAnyRole("ADMIN","MANAGER","MEMBER")
				//.anyRequest().authenticated()
				.anyRequest().permitAll()
				.and()
			.formLogin()
				.loginPage("/member/login")
//				.defaultSuccessUrl("/")
				.successHandler(userSuccessHandler)
//				.failureUrl("/member/login")
				.failureHandler(new UserLoginFailHandler())
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/member/logout")
//				.logoutSuccessUrl("/")
//				.addLogoutHandler(userLogoutHandler)
				.logoutSuccessHandler(userLogoutSuccessHandler)
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				.and()				
			.oauth2Login() //Social Login 설정
				.userInfoEndpoint()
				.userService(memberSocialService)
				
//			.sessionManagement()
//				.maximumSessions(1) //최대 허용 가능 세션 수, 만약 -1이라면 무한 
//				.maxSessionsPreventsLogin(true) //false : 이전 사용자 로그아웃 (세션 만료) true : 새로운 사용자 인증 실패
				;
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
}
