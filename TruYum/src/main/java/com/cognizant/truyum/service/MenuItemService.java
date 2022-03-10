package com.cognizant.truyum.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.exceptions.MenuITemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class MenuItemService {
	
	@Autowired
	MenuItemRepository menuItemRepository;
	
	@Transactional
	public List<MenuItem> getMenuItemListAdmin(){
		return menuItemRepository.findAll();
	}
	
	public List<MenuItem> getMenuItemListCustomer(){
		return menuItemRepository.findByActiveNotAndDateOfLaunchBefore(false, new Date());
	}
	
	public MenuItem getMenuItem(int id) throws MenuITemNotFoundException {
		Optional<MenuItem> optional = menuItemRepository.findById(id);
		if(optional.isPresent())
			return optional.get();	//return menu-item
		else 
			throw new MenuITemNotFoundException("Menu Item not found");
	}
	
	public MenuItem modifyMenuItem(MenuItem menuItem) {
		MenuItem menuItemNew = menuItemRepository.getOne(menuItem.getId());
		menuItemNew=menuItem;
		menuItemRepository.save(menuItemNew);
		return menuItem;
	}

	public MenuItem addMenuItem(MenuItem menuItem) {
		menuItemRepository.save(menuItem);
		return menuItem;
	}

}