package com.example.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.JdbcUserDetailsManagerConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
@EnableAsync
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
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
////		 NoOpPasswordEncoder.getInstance();
////		no contrutor beacuse it's a singleton class i.e at any moment there will be onle
////		one instanace in memory, which you access by getInstance();
//		
////		PasswordEncoder p= new StandardPasswordEncoder();
////		PasswordEncoder p= new StandardPasswordEncoder("secret");
////		you can pass secret string that will be used in hashing process
//		
////		PasswordEncoder p= new Pbkdf2PasswordEncoder();
////		there is also a overloaded fucntin which you can use to create more strong passwords.
//		
////		PasswordEncoder p= new BCryptPasswordEncoder();
////		there is also a overloaded fucntin which you can use to create more strong passwords.
//	
////		PasswordEncoder p= new SCryptPasswordEncoder();
////		there is also a overloaded fucntin which you can use to create more strong passwords.
//		return new BCryptPasswordEncoder();
//	}
	
	
//	The keys of the folllowing maps are actuually the prfix that must in every password in your database
//	so if the database password for your user has a prefxi of bcrypt then the delgatingpassencoder
//	invokes the bcrypt instance;
//	if you have not set the password prefix for your passwor you may run into
//	null pointer/ no passwordenoder mapped to id null key errors.
	@Bean
	public PasswordEncoder delegatingPassEncoder()
	{
	
		
//		Map<String,PasswordEncoder> map=new HashMap<>();
//		map.put("noop", NoOpPasswordEncoder.getInstance());
//		map.put("bcrypt", new BCryptPasswordEncoder());
//		
//		return new DelegatingPasswordEncoder("bcrypt", map);
		
//		Spring provided Delegating passwod encoder that defaults to Brcypt.
//		PasswordEncoder encoder=PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	
	}
	@Bean
	public AuthenticationProvider authenticationProvider()
	{
		return new CustomAuthenticationProvider();
	}
	
	@Bean
	public InitializingBean initCtx()
	{
		InitializingBean bean= new InitializingBean() {
			
			@Override
			public void afterPropertiesSet() throws Exception {
				SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
				
			}
		};
		
		return bean;
	}
	
	
}
