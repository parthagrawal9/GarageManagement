package com.spring.rest.spring_rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
//		super.configure(http);
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/api").authenticated();
	}	
}
