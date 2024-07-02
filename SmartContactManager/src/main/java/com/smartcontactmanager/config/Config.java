package com.smartcontactmanager.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
public class Config extends  WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService getUserDetailService() {

		return new UserDetailsServiceImpl();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticcationProvider() {

		DaoAuthenticationProvider daoauthenticationprovider = new DaoAuthenticationProvider();
		daoauthenticationprovider.setUserDetailsService(this.getUserDetailService());
		daoauthenticationprovider.setPasswordEncoder(passwordEncoder());

		return daoauthenticationprovider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticcationProvider());// here we are using database that's why DB authenticator otherwise inmemory Authentication
	}
	
	// handling URL
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN").antMatchers("/user/**").hasRole("USER")
		.antMatchers("/**").permitAll().and().formLogin().loginPage("/signin")
		.loginProcessingUrl("/do_login")
		.defaultSuccessUrl("/user/index")
		 .and().csrf().disable();
	}
}