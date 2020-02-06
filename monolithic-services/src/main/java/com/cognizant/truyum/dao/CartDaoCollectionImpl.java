package com.cognizant.truyum.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cognizant.truyum.dto.CartDTO;

import com.cognizant.truyum.model.MenuItem;
@Component
public class CartDaoCollectionImpl implements CartDao {
	private HashMap<String, CartDTO> userCarts=new HashMap<String, CartDTO>();
	CartDTO newCart = null;
	public CartDTO addCartItem(String userId, long menuItemId) {
		
		 
		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		MenuItem menuItem = menuItemDao.getMenuItem(menuItemId);
		if (userCarts.containsKey(userId)) {
			userCarts.get(userId).getMenuItemList().add(menuItem);

		} else {
			newCart = new CartDTO();
			ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();
			menuItems.add(menuItem);
			newCart.setMenuItemList(menuItems);
			//newCart.setTotal(total);
			userCarts.put(userId, newCart);
		}
		return newCart;

	}
	
	public CartDTO getAllCartItems(String userId)  {

		CartDTO cart = userCarts.get(userId);
		if (cart == null || cart.getMenuItemList().isEmpty()) {
			return null;
		}
		List<MenuItem> menuItemList = cart.getMenuItemList();
		float totalPrice = 0.0f;
		for (MenuItem menuItem : menuItemList) {
			totalPrice += menuItem.getPrice();
		}
		cart.setTotal(totalPrice);
		return cart;
	}

	@Override
	public void removeCartItem(String userId, long menuItemId) {
		 
		/*
		 * for(int i = 0; i<menuItemList.size(); i++) { if(menuItemList.get(i).getId()
		 * == menuItemId) menuItemList.remove(i); }
		 */
		for (MenuItem menuItem : userCarts.get(userId).getMenuItemList()) {
			if (menuItem.getId() == menuItemId) {
				userCarts.get(userId).getMenuItemList().remove(menuItem);
				break;
			}
			

		}

	}
		
	

	

}
