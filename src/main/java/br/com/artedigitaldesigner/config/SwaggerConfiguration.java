package br.com.artedigitaldesigner.config;

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

@Configuration //classe de configuração do Spring
@EnableSwagger2 //habilitando o swagger
public class SwaggerConfiguration {

	@Bean
	public Docket api() {
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("br.com.artedigitaldesigner"))
                .paths(PathSelectors.ant("/**"))
				.build()
				.apiInfo(apiInfo());		
	}	
	
	private ApiInfo apiInfo() {
	    return new ApiInfo(
	      "ERP Fraternidade Espírita Ramatis - Sistema para atender os diversos Departamentos da FER", 
	      "Sistema desenvolvido em JAVA SpringBoot API / Hibernate JPA.", 
	      "Versão 1.0 - 22/07/2021", 
	      "http://www.artedigitaldesigner.com.br/", 
	      new Contact("Arte Digital Designer", "http://www.artedigitaldesigner.com.br/", 
	    		  	"contato@artedigitaldesigner.com.br"), 
	      			"License of API", "http://www.artedigitaldesigner.com.br/", 
	      			Collections.emptyList());
	}	
}
