package com.dbs.web;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.dbs.web.service.AccountuserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	public SecurityConfig() {
		System.out.println("Security Config");
	}
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()
//		.withUser("user").password(encoder().encode("user")).roles("USER")
//		.and()
//		.withUser("admin").password(encoder().encode("admin")).roles("Admin");
//	}
	@Autowired
	private AccountuserService service;
	
	@Autowired
	private JwtRequestFilter filter;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		auth.userDetailsService(service);
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception{
		web.ignoring().antMatchers("/");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/client","/auth","custodian/login","/login").permitAll()
		.and().authorizeRequests()
		.antMatchers( HttpMethod.GET,"/custodian","custodian/login","/login").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.POST).hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		//.formLogin().and().logout();
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	}
	@Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
//	without the below function it will throw error as spring wants the password in encoder mode
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
}
