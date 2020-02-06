package com.cognizant.truyum.controller;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.TruyumApplication;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.AppUserDetailsService;
import com.cognizant.truyum.service.MenuItemService;

@RestController
//@CrossOrigin("localhost:4200")
@RequestMapping("/menu-items")
public class MenuItemController {
	@Autowired
	MenuItemService menuItemService;
	public static final Logger LOGGER = LoggerFactory.getLogger(TruyumApplication.class);
	@Autowired
	AppUserDetailsService appUserDetailsService;
	@GetMapping
	public List<MenuItem> getAllMenuItems() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		System.out.println("hello"+username);
		if(username=="anonymousUser")
			return menuItemService.getMenuItemList();
		UserDetails userDetails = appUserDetailsService.loadUserByUsername(username);
		String role = userDetails.getAuthorities().toArray()[0].toString();
		return menuItemService.getMenuItemList();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable("id") int id) {
		return menuItemService.getMenuItem(id);
	}
	@PutMapping()
	public void modifyMenuItem(@RequestBody MenuItem menuItem) {
		menuItemService.modifyMenuItem(menuItem);
		
	}

}
