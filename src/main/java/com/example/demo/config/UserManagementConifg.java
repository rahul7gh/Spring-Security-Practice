package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class UserManagementConifg {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public UserDetailsService detailsService()
	{
		System.out.println("Bean Created");
		String userQuery="select id,password,enabled from user where id= ?";
		String authQuery="select u.id,authority from user u,authorities a where u.id=a.id and  u.id= ?";
		UserDetailsService userDetailsService= new JdbcUserDetailsManager(dataSource);
		JdbcUserDetailsManagerConfigurer jdbcConfig=
		
		new JdbcUserDetailsManagerConfigurer<>((JdbcUserDetailsManager)userDetailsService);
		jdbcConfig.usersByUsernameQuery(userQuery);
		jdbcConfig.authoritiesByUsernameQuery(authQuery);
		System.out.println("Bean Created");
		return jdbcConfig.getUserDetailsService();
	}
	@Bean
	public PasswordEncoder passwordEncoder()
	{
//		 NoOpPasswordEncoder.getInstance();
//		no contrutor beacuse it's a singleton class i.e at any moment there will be onle
//		one instanace in memory, which you access by getInstance();
		
//		PasswordEncoder p= new StandardPasswordEncoder();
//		PasswordEncoder p= new StandardPasswordEncoder("secret");
//		you can pass secret string that will be used in hashing process
		
//		PasswordEncoder p= new Pbkdf2PasswordEncoder();
//		there is also a overloaded fucntin which you can use to create more strong passwords.
		
//		PasswordEncoder p= new BCryptPasswordEncoder();
//		there is also a overloaded fucntin which you can use to create more strong passwords.
	
//		PasswordEncoder p= new SCryptPasswordEncoder();
//		there is also a overloaded fucntin which you can use to create more strong passwords.
		return new BCryptPasswordEncoder();
	}
	
}
