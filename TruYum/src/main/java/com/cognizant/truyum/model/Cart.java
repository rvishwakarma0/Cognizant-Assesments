package com.cognizant.truyum.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table    
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ct_id")
	private int id;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="cart_menuitem",
	joinColumns = @JoinColumn(name="cart_id"),
	inverseJoinColumns = @JoinColumn(name="menu_id"))
	private Set<MenuItem> menuItems;
	
	@OneToOne
	@JoinColumn(name="ct_us_id")
	private User user;
	
	@Override
	public String toString() {
		return "Cart [menuItemList=" + ", total="+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void addMenuItem(MenuItem menuItem) {
		this.menuItems.add(menuItem);
	}
	
	public boolean removeMenuItem(MenuItem menuItem) {
		return this.menuItems.remove(menuItem);
	}

	public Set<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(Set<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}