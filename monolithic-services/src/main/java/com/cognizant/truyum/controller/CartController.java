package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.dto.CartDTO;
import com.cognizant.truyum.exception.CartEmptyException;
import com.cognizant.truyum.service.CartService;
@RestController
@RequestMapping("/carts")
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/{userId}/{menuItemId}")
	public void addCartItem(@RequestBody @PathVariable("userId") String userId, @PathVariable("menuItemId") int menuItemId) {
		
		System.out.println(userId+"    "+menuItemId);
		cartService.addCartItem(userId, menuItemId);
		
	}
	@GetMapping("/{userId}")
	public CartDTO getAllCartItems(@PathVariable("userId") String userId) throws CartEmptyException {
		//System.out.println(userId);
		CartDTO cartDTO = new CartDTO();
		try {
		cartDTO.setMenuItemList(cartService.getAllCartItems(userId));
		cartDTO.setTotal(cartService.getCartTotal(userId));
		//System.out.println(cartDTO.getMenuItemList());
		return cartDTO;
		}catch(CartEmptyException e) {
			throw new CartEmptyException();
		}
	}
	@DeleteMapping("/{userId}/{menuItemId}")
	public void removeCartItem(@PathVariable("userId") String userId, @PathVariable("menuItemId") int menuItemId) throws CartEmptyException {
		cartService.removeCartItem(userId, menuItemId);
	}

}
