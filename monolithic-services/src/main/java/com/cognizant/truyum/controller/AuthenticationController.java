package com.cognizant.truyum.controller;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AuthenticationController {
	public static final Logger LOGGER=LoggerFactory.getLogger(AuthenticationController.class);
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader){
		 LOGGER.info("Start authentication");
		 Map<String,String> jwt=new HashMap<>();
		 LOGGER.debug(authHeader);
		 String user=getUser(authHeader);
		 LOGGER.debug(user);
		 String token=generateJwt(user);
		 LOGGER.debug(token);
		 String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toArray()[0].toString();
		 LOGGER.debug(role);
		 jwt.put("role", role);
		 jwt.put("token", token);
		 jwt.put("user", user);
		 LOGGER.info("End authentication");
		 return jwt;
	}
	
	 private String getUser(String authHeader) {
		 String encodedCredentials = authHeader.split(" ")[1];
		 byte[] decodedCredentials=Base64.getDecoder().decode(encodedCredentials);
		 String user=new String(decodedCredentials).split(":")[0];
		 //String token=generateJwt(user);
		return user;
	 }
	 
	 private String generateJwt(String user) {
		    JwtBuilder builder = Jwts.builder();
	        builder.setSubject(user);

	        // Set the token issue time as current time
	        builder.setIssuedAt(new Date());

	        // Set the token expiry as 20 minutes from now
	        builder.setExpiration(new Date((new Date()).getTime() + 1200000));
	        builder.signWith(SignatureAlgorithm.HS256, "secretkey");

	        String token = builder.compact();

	        return token;
	 }
}