package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.components.JpaAuthority;
import com.example.demo.components.JpaUser;

@RestController
public class DefController {
	
	@Autowired
	CrudRepository<JpaUser, Long> userRepository;
	
	@Autowired
	CrudRepository<JpaAuthority, Long> authRepositry;
	
	/*
	 * 1.Deafult strategy is MODE_THREADLOCAL:- Spirng Uses ThreadLocal class
	 * instacnce to manage the context which is implemenation provided by JDK. This
	 * works as acollection of data but makes sure each thread sees the only data in
	 * collection.
	 * No Thread can see others ThreadLocal.
	 * And in webapps each request will have it's own Security Context.
	 * SO when a new @Async thread is created nothing gets copied.
	 * 
	 */
//	@GetMapping("/secconfig")
//	public String getConfig()
//	{
//		SecurityContext ctx= SecurityContextHolder.getContext();
//		Authentication auth=ctx.getAuthentication();
//		return auth.getName()+" is Authenticated!";
//	}
	
	/*
	 * ACtually There is no need of explicit SecurityContexHolder .SPrng actually
	 * injeccts the AUthentication Object at method level.
	 */
	@GetMapping("/secctx1")
	public String getConfig(Authentication auth)
	{
//		SecurityContext ctx= SecurityContextHolder.getContext();
//		Authentication auth=ctx.getAuthentication();
		return auth.getName()+" is Authenticated!";
	}
	
	/*
	 * Making endpoint asynchronnous meansthe thread that executes this method may
	 * not ne the same thread which served this request
	 * ****NOTE: make sure you have @Enableasync on any of the config classes!
	 * The following code results in null pointer beacuse the thread that executed this has no access to the 
	 * security context of other thread where "ctx.getAUthenteication()" is executed the authenticated Authentication Object exist.
	 * so weed to make it inehrit the Sec conext of other thread. We can do it by 2 ways:
	 * 1. SecurityContextHolder.setStrategyByName(); :-  put this in WebAUthConfig
	 * class.
	 * 2.spring.security.strategy
	 *  
	 */
	
	
//	The Async is made to execute a task in background so it won't commuicate 
//	directly with spring threads that are servicing the requests so your return statements
//	won't work directly This is why we need to use CompletableFuture.
	
//	NOTE****The sce context gets passed to only threads cretaed by @Async because these are managed
//	by spring it self. Any user Created thread you'll have to handle the cotext passing yourselves.
	
	
	/*
	 * //You can also set the strategy to MODEGLOBAL but it's not recommended to
	 * webapplications as each request is unqiue so having epaat context is good.
	 * A standalone applicatio can use this strategy. This is Thread Unsafe so you have
	 * to handl concurrent access.
	 */
	
	
	
	@GetMapping("/secctx2")
	@Async
	public CompletableFuture<String> asyncDemo(Authentication auth)
	{
//		SecurityContext ctx= SecurityContextHolder.getContext();
//		Authentication auth= ctx.getAuthentication();
		System.out.println(auth.getName());
		return CompletableFuture.completedFuture("GG"+auth.getName());
		
	}
	
	
	
	
	@GetMapping("/")
	public ResponseEntity<String> welcome(HttpServletRequest request,HttpServletResponse response)
	{
		return ResponseEntity.ok("Welcome Bhay!");
	}
	
	@GetMapping("/nope")
	public ResponseEntity<String> Noauth()
	{
		return ResponseEntity.ok("No Auth here Welcome Bhay!");
	}
	
	@GetMapping("/users")
	List<JpaUser> getData()
	{
		return (List<JpaUser>) userRepository.findAll();
	}
	
	@GetMapping("/auths")
	List<JpaAuthority> getAuths()
	{
		return (List<JpaAuthority>) authRepositry.findAll();
	}
}
