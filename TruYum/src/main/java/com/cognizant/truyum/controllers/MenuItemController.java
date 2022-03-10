package com.cognizant.truyum.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exceptions.MenuITemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.service.MenuItemService;


@RestController
@RequestMapping("/menu-items")
public class MenuItemController {
	
	@Autowired
	MenuItemService service;
	
	@GetMapping("/")
	public List<MenuItem> getMenuItems() {
		System.out.println("***************hello**********");
		return service.getMenuItemListAdmin();
	}
	
	@GetMapping("/{id}")
	public MenuItem getMenuItem(@PathVariable("id") int id) throws MenuITemNotFoundException {
		return service.getMenuItem(id);
	}
	
	@PutMapping("/")
	public MenuItem modifyMenuItem(@RequestBody MenuItem menuItem) {
		return service.modifyMenuItem(menuItem);
	}
	
	@PostMapping("/")
	public MenuItem addMenuItem(@RequestBody MenuItem menuItem) {
		return service.addMenuItem(menuItem);
	}
	
}