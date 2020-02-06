package com.cognizant.truyum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.core.userdetails.User;


import com.cognizant.truyum.exception.UserAlreadyExistsException;

import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.service.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	AppUserDetailsService appUserDetailsService;
	//InMemoryUserDetailsManager inMemoryUserDetailsManager = new InMemoryUserDetailsManager();

	

	@PostMapping
	public void signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException {
		System.out.println(passwordEncoder().encode(user.getPassword()));
		user.setPassword(passwordEncoder().encode(user.getPassword()));
		appUserDetailsService.signUp(user);
		/*
		 * if(inMemoryUserDetailsManager.userExists(user.getUserName())) { throw new
		 * UserAlreadyExistsException(); }
		 * inMemoryUserDetailsManager.createUser(User.withUsername(user.getUserName()).
		 * password(passwordEncoder().encode(user.getPassword())).roles("USER").build())
		 * ;
		 */
	}

	public PasswordEncoder passwordEncoder() {
        //LOGGER.info("Start");
        return new BCryptPasswordEncoder();
    }

}
