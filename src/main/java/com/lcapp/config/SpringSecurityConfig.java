package com.lcapp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private PasswordEncoder bcrypt;
	@Autowired
	private DataSource dataSource;
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	auth.inMemoryAuthentication()
	.withUser("shubham")
	.password(bcrypt.encode("12345"))
	.roles("admin");
		auth.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(bcrypt);
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.antMatchers("/")
		.authenticated().antMatchers("/viewAppHistory")
		.authenticated().and()
		.formLogin()
		.loginPage("/loginPage")
		.loginProcessingUrl("/processLogin").and()
		.httpBasic().and().logout();
	}
	
	
}
