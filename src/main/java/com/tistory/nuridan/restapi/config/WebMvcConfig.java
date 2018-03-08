package com.tistory.nuridan.restapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.tistory.nuridan.restapi.config.version.ApiVersionRequestMappingHandlerMapping;

/**
 * WEB MVC 기본설정
 * @author nuridan@nate.com
 * @since 2017-09-22
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
    protected RequestMappingHandlerMapping createRequestMappingHandlerMapping() {
		return new ApiVersionRequestMappingHandlerMapping("api/v");
	}
    
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
	        .addResourceHandler("swagger-ui.html")
	        .addResourceLocations("classpath:/META-INF/resources/");
        
        registry
	        .addResourceHandler("/webjars/**")
	        .addResourceLocations("classpath:/META-INF/resources/webjars/");
        
        super.addResourceHandlers(registry);
    }
    
}

