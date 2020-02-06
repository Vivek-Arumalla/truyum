package com.cognizant.truyum.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.Role;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.RoleRepository;
import com.cognizant.truyum.repository.UserRepository;
import com.cognizant.truyum.security.AppUser;

@Service
public class AppUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;

	public AppUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		
		Users user = userRepository.findByUserName(userName);
		if (user == null) {
			throw new UsernameNotFoundException(userName);
		}
		return new AppUser(user);
	}
	public void signUp(Users user) throws UserAlreadyExistsException {
		if(userRepository.findByUserName(user.getUserName()) != null) {
			throw new UserAlreadyExistsException();
		}
		else {
			Set<Role> roles = new HashSet<>();
			Role role = roleRepository.findById(1).get();			
			roles.add(role);
			user.setRoleList(roles);
			userRepository.save(user);
			
			//roleRepository.save(userRepository.findByUserName(user.getUserName()).getId());
		}
	}

}
