package com.cognizant.truyum.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.exceptions.CartEmptyException;
import com.cognizant.truyum.exceptions.CartNotFOundException;
import com.cognizant.truyum.exceptions.MenuITemNotFoundException;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.User;
import com.cognizant.truyum.repository.CartRepositroy;
import com.cognizant.truyum.repository.MenuItemRepository;

@Service
public class CartService {
	
	@Autowired
	CartRepositroy cartRepositroy;
	
	@Autowired
	MenuItemService menuItemService;
	
	@Autowired
	UserService userService;
	
	
	public Cart getCartByUserId(int uid) throws CartNotFOundException{
		Optional<Cart> optional = cartRepositroy.findCartByUserId(uid);
		if(optional.isPresent())
			return optional.get();	//return menu-item
		else 
			throw new CartNotFOundException("Cart not found for "+ uid);
	}
	
	public Cart createCartForUser(User u) {
		Cart cart = new Cart();
		cart.setUser(u);
		cart.setMenuItems(new HashSet<MenuItem>());
		cartRepositroy.save(cart);
		return cart;
	}
	
	public void addCartItem(int userId, int menuItemId) throws Exception {
		Cart cart = null;
		
		try {
			cart = getCartByUserId(userId);
		} 
		catch (Exception e) { 
			cart = createCartForUser(userService.getUserById(userId));
		}
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		cart.addMenuItem(menuItem);
		cartRepositroy.save(cart);
	}
	
	public  Set<MenuItem> getCartItems(int uid) throws CartNotFOundException {
		Cart cart = getCartByUserId(uid);
		return cart.getMenuItems();
	}
	
	public void removeCartItem(int userId, int menuItemId) throws Exception {
		Cart cart = getCartByUserId(userId);
		MenuItem menuItem = menuItemService.getMenuItem(menuItemId);
		if(cart.getMenuItems().isEmpty())
			throw new CartEmptyException("Cart is Empty");
		if(cart.removeMenuItem(menuItem))
			cartRepositroy.save(cart);
		else 
			throw new Exception("Item not available in the cart");
		
	}

}