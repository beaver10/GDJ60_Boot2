package com.iu.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
//@EnableWebSecurity
public class SecurityConfig {

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
				.antMatchers("/notice/add").hasRole("ADMIN")
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
				.defaultSuccessUrl("/")
				.failureUrl("/member/login")
				.permitAll()
				.and()
			.logout()
				.logoutUrl("/logout")
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.permitAll()
				
				;
		
		return httpSecurity.build();
	}
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	
	
}
