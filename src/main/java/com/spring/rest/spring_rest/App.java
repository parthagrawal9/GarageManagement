package com.spring.rest.spring_rest;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class App 
{
    public static void main( String[] args ) throws AddressException, MessagingException
    {
    	SpringApplication.run(App.class, args);
    }
}

	      