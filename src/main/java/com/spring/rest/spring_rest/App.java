package com.spring.rest.spring_rest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args ) throws AddressException, MessagingException
    {
    	SpringApplication.run(App.class, args);
    }
    
    @Autowired
    public void authenticationManager(AuthenticationManagerBuilder builder, final UserRepository repo) throws Exception{
    	builder.userDetailsService(new UserDetailsService() {
			
			@Override
			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
				return new CustomUserDetails(repo.findByUserName(s));
			}
		});
    }
}

	      