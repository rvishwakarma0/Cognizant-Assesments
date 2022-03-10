package com.cognizant.truyum.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exceptions.CartNotFOundException;
import com.cognizant.truyum.exceptions.MenuITemNotFoundException;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.service.CartService;
import com.cognizant.truyum.service.MenuItemService;
import com.cognizant.truyum.service.UserService;

@RestController
@RequestMapping("/carts")
public class CartController {
	
	@Autowired
	CartService service;
	
	@Autowired
	UserService userService;
	
	@PostMapping("/{menuItemId}")
	public void addCartItem(@PathVariable("menuItemId") int menuItemId) throws Exception{
		User user = userService.getUser();
		service.addCartItem(user.getId(), menuItemId);
	}
	
	@GetMapping("/cart")
	public Set<MenuItem> getAllCartItems() throws CartNotFOundException {
		User user = userService.getUser();
		return service.getCartItems(user.getId());
	}
	
	@DeleteMapping("/{menuItemId}")
	public void removeCartItem(@PathVariable("menuItemId") int menuItemId) throws Exception{
		User user = userService.getUser();
		service.removeCartItem(user.getId(), menuItemId);
	}
	
	
}