package com.example.demo.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.demo.components.CustomAuthenticationProvider;

/*
 * We can override the default configuration of spring security by following ways:-
 * UandP1. You create your own beans for userdetails service and passwordEncoder.
 * 	below two @Bean Methods do this.
 * UandP2.Configuring by overriding configure(AuthmanagerBuilder)
 *  here in tis we are directly configuring the authnticationmanager to use ur own userdetails service and passwordencoder
 * 
 *  Both the above approaches are good and differentin teher own way.
 *  you shoulld configure your application in one of the way only...mixing
 *  these will result in cofusion only.
 *  i.e for eg...defininga @Bean for Password enoder and confguring UserDetailsService
 *  via authentcationManagerBuilder from configure method.
 *  
 *  It works but mxing will uncecsarily make your code complex to understand
 *  
 *  UandP3.Not at allrecommended.using auth manager instance methods
 *  its better to keep everythinh loosely coupled and connect
 *  the dots afterwords.
 *  
 */

//@Configuration
public class ProjectConfig 
//extends WebSecurityConfigurerAdapter 
{
//
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.httpBasic();
//		http.authorizeRequests().anyRequest().authenticated();
//	}

//	UandP3rd Approach
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication()
//		.withUser("Thik")
//		.password("plox")
//		.authorities(new SimpleGrantedAuthority("read"))
//		.and()
//		.passwordEncoder(NoOpPasswordEncoder.getInstance());
//	}
//	
	
//	UandP2nd Appraoch 
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		User user = new User("yosh", "plox", Collections.singleton(new SimpleGrantedAuthority("read")));
//
//		UserDetailsService userDetailsService = new InMemoryUserDetailsManager(user);
//		auth.userDetailsService(userDetailsService).passwordEncoder(NoOpPasswordEncoder.getInstance());
//
//	}

//	UandP!st Appraoch
//	@Bean
//	public UserDetailsService userDetailsService()
//	{
//		List<UserDetails> users= new ArrayList<>();
//		users.add(User.withUsername("rahul").password("rahul")
//				.authorities("read").build());
//		UserDetailsService userDetailsService=
//				new InMemoryUserDetailsManager(users);
//		
//		return userDetailsService;
//	}
//	@Bean
//	public PasswordEncoder passwordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}

	/*
	 * All the above ways are for configuring UandP for our authentication.
	 * Following half is for configuring the upper lavel of UandP i.e the
	 * AuthenticationProvider.
	 * 
	 * ****I have kept the Bean implementations for UandP
	 * 
	 *  AuthenticationProvider is the component that compares the Data coming in the request 
	 *  with info given by PasswordEncoder(Verify is incoming password is correct) and UserDetails(Fetch user details) service. so UandP are just info carriers.
	 * This is what we call delegating responsibilities and getting a loosely coupled application.
	 * 
	 * The beauty of sring is that due to these sepration of responsibilities you can do whatevr you want
	 * (ofc you shouldn't mess with spings flow but you can ...)
	 * i.e you can create a auth provider that does not require UandP at all.
	 * 
	 * To define your own AUth Provide you must implement Authentication Provider interface and override 
	 * required methods pls check compononets,CustomAuthenticationProvider Method.
	 * 
	 * 
	 *  
	*/
//	Making the CUstomAUth Compoenent gives the responsibility of creating requred bean i.e object also to Spring.
//	but in case you want to have that as a normal class you ca define your object as ean as follows....
//	it will still work OP>
//	@Bean
//	public AuthenticationProvider customAuth()
//	{
//		return new CustomAuthenticationProvider();
//	}
	
	/*
	 * Having your own bean tells spring to use it...you don'r need to do anything but you should 
	 * do the configuration spring to use your customauth your self.
	 * we can do this by attaching our customauth object to authmanager builder in configure method
	 */
	
//	@Autowired
//	CustomAuthenticationProvider authenticationProvider;
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		 auth.authenticationProvider(authenticationProvider);
//	}
	/*
	 * Currently we have both our auth settings and UandP in a single class.It will be better
	 * if have different config classes for different Responsibilities.
	 * UserManagement Cobfig supplying UandP beans and WebAuthorizationConfig overriding configure method.
	
	 */
	
}

