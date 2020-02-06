package com.cognizant.truyum.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.repository.MenuItemRepository;
import com.cognizant.truyum.repository.UserRepository;



@Service
public class CartService {
	//@Autowired
	//CartDao cartDao = new CartDaoCollectionImpl();
	@Autowired
	UserRepository userRepository;
	@Autowired
	MenuItemRepository menuItemRepository;
	
	public void addCartItem(String userId, int menuItemId) {
		
		 Users user = userRepository.findByUserName(userId);
		 MenuItem menuItem = menuItemRepository.findById(menuItemId).get();
		 user.getMenuItemList().add(menuItem);
		 userRepository.save(user);
		 
	}
	

	public List<MenuItem> getAllCartItems(String userId) throws CartEmptyException {
		Users users=userRepository.findByUserName(userId);
		try {			
			users.setMenuItemList(userRepository.getMenuItems(userId));
			System.out.println(userRepository.getMenuItems(userId));
			return users.getMenuItemList();					
			
		} catch (CartEmptyException e) {
			throw new CartEmptyException();
		}
	}
	public double getCartTotal(String userId) throws CartEmptyException {
		double cartTotal=0.0;
	
		try {
			cartTotal= userRepository.getCartTotal(userId);
		}catch(CartEmptyException e) {
			throw new CartEmptyException();
		}
		return cartTotal;
				
	}
	public void removeCartItem(String userId, long menuItemId)throws CartEmptyException {
		try {
		List<MenuItem> menuItemList = userRepository.getMenuItems(userId);
		Users users = userRepository.findByUserName(userId);
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId) {
				menuItemList.remove(menuItem);
				break;
			}
		}
		users.setMenuItemList(menuItemList);
		userRepository.save(users);
		}
		catch(Exception e) {
			throw new CartEmptyException();
		}
		
	}
	

}
