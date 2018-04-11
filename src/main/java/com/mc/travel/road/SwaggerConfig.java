/**
 * 
 */
package com.mc.travel.road;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Tarundeep Singh
 * Configures Swagger Engine. Used for API documentation.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
	
	private static final String API_DESC = "This API informs whether two cities in USA are connected via a series of roads. In case you want to have this API expose information regarding your city, or your country, please contact the developer.";
			
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("com.mc.travel.road"))              
          .paths(PathSelectors.any())                          
          .build()
          .apiInfo(apiInfo());                                           
    }
	
	private ApiInfo apiInfo() {
	     return new ApiInfo(
	       "City Connectivity API", 
	       API_DESC, 
	       "Open Source", 
	       "Terms of service (None) ", 
	       new Contact("Tarundeep Singh", "", "tarunthecoder@gmail.com"), 
	       "License of API", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());
	}
}
