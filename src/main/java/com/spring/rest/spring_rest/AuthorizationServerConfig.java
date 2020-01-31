//package com.spring.rest.spring_rest;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//
//@Configuration
//@EnableAuthorizationServer
//@EnableWebSecurity
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//				super.configure(endpoints);
//		endpoints.authenticationManager(authenticationManager);
//	}
//
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
////		super.configure(security);
////		SecurityConfigurerAdapter<O, SecurityBuilder<O>>
//		security.checkTokenAccess("isAuthenticated()");
//	}
//
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
////		super.configure(clients);
//		clients.inMemory().withClient("my-trusted-client")
//			.authorizedGrantTypes("client_credentials","password")
//			.authorities("ROLE_CLIENT","ROLE_TRUSTED_CLIENT")
//			.scopes("read","write","trust")
//			.resourceIds("oauth2-resource")
//			.accessTokenValiditySeconds(5000)
//			.secret("secret");
//	}	
//	
//	@Bean
//	public  WebSecurityConfigurer  getWebsecurityConf() {
//		return new WebSecurityConfigurerAdapter(){
//			@Override
//			protected void configure(HttpSecurity http) throws Exception {
//				http.cors();
//				}
//		};
//	}
//
//}
//
////@Bean
////public WebMvcConfigurer corsConfigurer() {
////	return new WebMvcConfigurerAdapter(){
////		@Override
////		public void addCorsMappings(CorsRegistry registry) {
////			registry.addMapping("/**").allowedMethods("*");
////		}
////	};
////}
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
