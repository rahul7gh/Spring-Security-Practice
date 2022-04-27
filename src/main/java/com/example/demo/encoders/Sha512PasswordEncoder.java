package com.example.demo.encoders;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.password.PasswordEncoder;

public class Sha512PasswordEncoder implements PasswordEncoder {

	@Override 
	public String encode(CharSequence rawPassword )
	{
		return get512Hash(rawPassword.toString());
	}
	
	@Override
	public boolean matches(CharSequence rawPassword, String encoded)
	{
		String hashedRawPassword= encode(rawPassword);
		
		return hashedRawPassword.equals(encoded);
	}
	private String get512Hash(String input)
	{
		StringBuilder result=new StringBuilder();
		try
		{
			MessageDigest md= MessageDigest.getInstance("SHA-512");
			byte[] digested =  md.digest(input.getBytes());
			for(int i=0;i<digested.length;i++)
			{
				result.append(Integer.toHexString(0xFF & digested[i]));
			}
		}
		catch(NoSuchAlgorithmException e)
		{
			throw new RuntimeException("Bad Algorithm!");
		}
		
		
		return result.toString();
	}
}
