package com.cognizant.truyum.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
	@Autowired
	MenuItemRepository menuItemRepository;
	
	public List<MenuItem> getMenuItemList() {
		return menuItemRepository.findAll();
	}

	public MenuItem getMenuItem(int id) {
		
		return menuItemRepository.findById(id).get();
	}
	
	
	public void modifyMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
		
	}

}
