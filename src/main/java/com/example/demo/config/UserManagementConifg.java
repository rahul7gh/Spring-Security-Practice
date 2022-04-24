package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class UserManagementConifg {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public UserDetailsService detailsService()
	{
		System.out.println("Bean Created");
		String userQuery="select username,password,enabled from user where username= ?";
		String authQuery="select username,authority from user u,authorities a where u.id=a.id and  username= ?";
		UserDetailsService userDetailsService= new JdbcUserDetailsManager(dataSource);
		JdbcUserDetailsManagerConfigurer jdbcConfig=
		
		new JdbcUserDetailsManagerConfigurer<>((JdbcUserDetailsManager)userDetailsService);
		jdbcConfig.usersByUsernameQuery(userQuery);
		jdbcConfig.authoritiesByUsernameQuery(authQuery);
		return jdbcConfig.getUserDetailsService();
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		return NoOpPasswordEncoder.getInstance();
	}
	
}
