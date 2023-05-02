package com.helpDeskPortal.HDP.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class HeplDeskPortalSecurityConfig extends WebSecurityConfigurerAdapter {
		
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
        .antMatchers("/**").permitAll().anyRequest().authenticated()
        .and().formLogin().permitAll().and().logout().permitAll().and().httpBasic();
        http.cors().disable().csrf().disable();
        
//        it is woring initialiy  ......      
//        http.authorizeRequests()
//        .antMatchers("/**").permitAll().anyRequest().authenticated()
//        .and().formLogin().permitAll().and().logout().permitAll().and().httpBasic();
//        http.cors().disable().csrf().disable();
		
	}
	
	    //beans
		//bcrypt bean definition
		@Bean
		public BCryptPasswordEncoder passwordEncoder() {
			return new BCryptPasswordEncoder();
		}
		
		
}
