package com.iu.base.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lombok.extern.slf4j.Slf4j;


@Configuration //***-context.xml
@Slf4j
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${app.upload.base}")
	private String basePath;
	
	@Value("${app.url.path}")
	private String urlPath;

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// TODO Auto-generated method stub
		
		
		registry.addResourceHandler(urlPath)
		.addResourceLocations(basePath);
		
	}
	
}
