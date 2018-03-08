package com.tistory.nuridan.restapi.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.Contact;
import springfox.documentation.service.SecurityScheme;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 스웨거 기본설정
 * @author nuridan@nate.com
 * @since 2017-09-22
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
    @Bean
    public Docket api() {
    	
    	List<SecurityScheme> schemeList = new ArrayList<SecurityScheme>();
    	schemeList.add(new ApiKey("accessToken", "Authorization", "header"));
    	
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tistory.nuridan.restapi"))
                .paths(PathSelectors.regex("/api/.*"))
                .build()
                .apiInfo(apiInfo())
                .securitySchemes(schemeList)
                .useDefaultResponseMessages(true);
    }
    
    private ApiInfo apiInfo() {
    	
    	return new ApiInfoBuilder()
    		.title("Rest API")
    		.description("")
    		.version("1.0.0")
    		.licenseUrl("http://nuridan.tistory.com")
    		.contact(new Contact("숙취", null, "nuridan@nate.com"))
    		.build();
    }

}