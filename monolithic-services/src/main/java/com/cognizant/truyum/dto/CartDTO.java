package com.cognizant.truyum.dto;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cognizant.truyum.model.MenuItem;

public class CartDTO {
	private static final Logger LOGGER = LoggerFactory.getLogger(CartDTO.class);
	private List<MenuItem> menuItemList;
	int count;
	double total;
	public CartDTO() {
		
	}
	
	public CartDTO(List<MenuItem> menuItemList, double total) {
		super();
		this.menuItemList = menuItemList;
		this.total = total;
	}

	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}
	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "CartDTO [menuItemList=" + menuItemList + ", count=" + count + ", total=" + total + "]";
	}

	
}
