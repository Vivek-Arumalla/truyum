package com.cognizant.truyum.dao;

import com.cognizant.truyum.dto.CartDTO;


public interface CartDao {
	public CartDTO addCartItem(String userId, long menuItemId);

	public CartDTO getAllCartItems(String userId) ;

	public void removeCartItem(String userId, long menuItemId);

}
