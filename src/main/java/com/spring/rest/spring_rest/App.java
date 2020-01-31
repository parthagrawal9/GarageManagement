package com.spring.rest.spring_rest;

import java.util.Arrays;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args ) throws AddressException, MessagingException
    {
    	SpringApplication.run(App.class, args);
//    	System.out.println(SpringVersion.getVersion());
    }
    
//    @Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter(){
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**").allowedMethods("*");
//			}
//		};
//	}
//    
//    @Autowired
//    public void authenticationManager(AuthenticationManagerBuilder builder, final UserRepository repo) throws Exception{
//    	builder.userDetailsService(new UserDetailsService() {
//			
//			@Override
//			public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//				if(repo.count() == 0){
//					repo.save(new Login("user","user",Arrays.asList(new Role("USER"),new Role("ACTUATOR"))));
//				}
//				return new CustomUserDetails(repo.findByUserName(s));
//			}
//		});
//    }
}

	      