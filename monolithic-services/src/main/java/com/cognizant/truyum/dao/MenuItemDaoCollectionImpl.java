package com.cognizant.truyum.dao;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.cognizant.truyum.model.MenuItem;

@Component
public class MenuItemDaoCollectionImpl implements MenuItemDao {
	private static ArrayList<MenuItem> menuItemList;
	

	public MenuItemDaoCollectionImpl() {

		super();
		
			ApplicationContext container = new ClassPathXmlApplicationContext("truyum.xml");
			menuItemList=container.getBean("menuItemList",ArrayList.class);
			
			

		}

	

	@Override
	public List<MenuItem> getMenuItemListAdmin() {

		return menuItemList;
	}

	@Override
	public List<MenuItem> getMenuItemListCustomer() {
		
		
		
		return menuItemList;
		
	}

	@Override
	public void modifyMenuItem(MenuItem menuItem) {
		// TODO Auto-generated method stub
		for (int i = 0; i < menuItemList.size(); i++) {
			if (menuItemList.get(i).getId() == menuItem.getId())
				menuItemList.set(i, menuItem);
		}

	}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getId() == menuItemId)
				return menuItem;
		}
		return null;
	}

	

}



