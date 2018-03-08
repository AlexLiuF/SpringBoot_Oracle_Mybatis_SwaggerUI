package com.tistory.nuridan.restapi.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.tistory.nuridan.restapi.config.filter.CORSFilter;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean getFilterRegistrationBean() {
		
		FilterRegistrationBean bean = new FilterRegistrationBean(new CORSFilter());
		bean.addUrlPatterns("*");
		
		return bean;
	}
}
