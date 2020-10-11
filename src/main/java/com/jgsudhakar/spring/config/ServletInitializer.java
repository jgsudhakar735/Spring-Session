package com.jgsudhakar.spring.config;

import com.jgsudhakar.spring.SpringSessionApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * This is required when we are deploying as war in tomcat or any other server
 * @Author : Sudhakar Tangellapalli
 * @File : com.jgsudhakar.spring.config.ServletInitializer
 * @Date : 09/10/2020
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringSessionApplication.class);
	}

}
