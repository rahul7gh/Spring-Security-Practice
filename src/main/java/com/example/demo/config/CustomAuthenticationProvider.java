package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

//This gives responsibility of creating object to spring. If you don't want to use this
//you must provide an object of this class via @bean annotataed Method!.
//@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	
	/*
	 * 1.UserdetailsSevice tries to find the UserDeatislObject by username:-
	 * a)return s Userdetails Onject if found b) thorw AuthenticationException if
	 * not found. 2.Password encoder encodes the incoming password and tries to
	 * match with encoded password from the Userdeatisl object: a) if true return
	 * the authentication object b)if false thorw BadCredExcepton
	 */
	
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired 
	PasswordEncoder passwordEncoder;
	
	
	
	/*
	 * We still need these above two to fetch use details,right?
	 * so our authenticate method will use these objects to fetch data and validate it with
	 * data received from the autheticate object.
	 */		
	
	
	/*
	 * This method implements the authentication logic.
	 * 1.thorws AuthenticationException if auth fails.
	 * 2.if teh Authentication object received is not supported by this auth provider then this should return null
	 * for eg. we may have two auth provider one uses username and password while the other requires
	 * username and OTP.SO weach of these reqires a different auth objects adn must be handled by different auth providers
	 * we achieve this by having different HTTP-filter levels.
	 * 3.Methd should return a authentication object represeenting a ffully authenicated Object.so for this 
	 * object isAuthenticated must return true;
	 * This object should not contain te passowrd/code used in the authentication beacuse after the object 
	 * is authemticated we dont need password.
	 * 
	 *returns:-
	 *	1.authneticated object:- success
	 *	2.AuthentiatonException:- Failed
	 *	3.null :- Unable to decide.  
	 * 
	 */	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username=authentication.getName();
		String password=authentication.getCredentials().toString();
		
		UserDetails userDetails= userDetailsService.loadUserByUsername(username);
		
		System.out.println(passwordEncoder.encode(password));
		if(!passwordEncoder.matches(password, userDetails.getPassword()))
		{
			/*we need to raise a AuthenticationException so BadCredtialsExecption extends
			 * AUthenticationException class and we can throw it.
			 * It is recommended to throw specific execption based on the cause.
			 * 
			*/
			throw new BadCredentialsException("Username or Password is incorrect!");
		}
//		Note we have not covered the case where we return null by checking some details...
	
		return new UsernamePasswordAuthenticationToken(username, password,userDetails.getAuthorities());
	}

	
	
	/*This method can be used to decide if the authentication object received is supported by this provider
	* or not.
	* Note that even if this might return true the authenticate method may reject request
	* and return null.
	* This scenario allows us to reject the request by Details of auth Object and not only its types.
	* 
	* so if supports returend false then we need to go to other auth provider.
	*AuthenticationManager is the one which send the incoming AUthentication object to available
	*authenticationProvider.
	*
	
	*/
	@Override
	public boolean supports(Class<?> authentication) {
		
	/*This mtehod will return  true if the authentication object if of type
	 * UsernamePasswordAuthenticationToken other wise false.
	 * UsernamePassowrdAuthenticationToken si the standard implementaion of AUthentication
	 * interface representing standard auth request with username and password.
	 
	 
	 */
		
		return authentication
				.equals(UsernamePasswordAuthenticationToken.class);
	}

	
	
	
}
