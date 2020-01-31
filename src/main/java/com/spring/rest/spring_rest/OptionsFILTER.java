//package com.spring.rest.spring_rest;
//
//import java.io.IOException;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class OptionsFILTER implements Filter {
//
//	@Override
//	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
//			throws IOException, ServletException {
//		
//        HttpServletResponse response = (HttpServletResponse) res;
//        HttpServletRequest request= (HttpServletRequest) req;
//
//        if (request.getMethod().equalsIgnoreCase("OPTIONS")){
//        	System.out.println("Options method foun d");
//        	response.setStatus(200);
////        	response.getOutputStream().write(null);
//        }
//        else {
//        	chain.doFilter(req, res);
//        }
//		
//	}
//
//}
