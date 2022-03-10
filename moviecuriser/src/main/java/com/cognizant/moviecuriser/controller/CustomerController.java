package com.cognizant.moviecuriser.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecuriser.exception.MovieNotFoundException;
import com.cognizant.moviecuriser.model.Favorities;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.model.User;
import com.cognizant.moviecuriser.service.CustomerService;

@RestController
public class CustomerController {
	
	
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/customerHome")
	public ResponseEntity<List<Movie>> customerHome(){
		return new ResponseEntity<>(customerService.getAllMoviesForCustomer(), HttpStatus.OK);
	}
	
	@PostMapping("/addToFavorities")
	public ResponseEntity<Favorities> addToFavorite(@RequestParam("mId") int mId) throws MovieNotFoundException {
		User user = customerService.getUser();
		return new ResponseEntity<>(customerService.addToFavorites(user, mId),HttpStatus.CREATED);
	}
	
	
	@GetMapping("/favoritiesMovies")
	public ResponseEntity<List<Movie>> getAllFavorites() {
		User user = customerService.getUser();
		return new ResponseEntity<>(customerService.getAllFavoritesMovie(user),HttpStatus.OK);
				
	}
	
	@DeleteMapping("/deleteFromFavorities")
	public ResponseEntity<String> removeFromFavorite(@RequestParam("mId") int mId) throws MovieNotFoundException {
		User user = customerService.getUser();
		boolean res = customerService.removeFromFavorities(user, mId);
		if(res)
			return new ResponseEntity<>("Deleted Successfully",HttpStatus.OK);
		return new ResponseEntity<>("Delete Unsuccessfull",HttpStatus.OK);
	}

}
