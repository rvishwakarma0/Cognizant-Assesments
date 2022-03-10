package com.cognizant.moviecuriser.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cognizant.moviecuriser.exception.MovieNotFoundException;
import com.cognizant.moviecuriser.model.Favorities;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.model.User;
import com.cognizant.moviecuriser.repository.FavoritiesRepository;
import com.cognizant.moviecuriser.repository.MovieRepository;
import com.cognizant.moviecuriser.repository.UserRepository;

@Service
public class CustomerService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);
	
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	FavoritiesRepository favoritiesRepository;
	@Autowired
	UserRepository userRepository;
	
	public List<Movie> getAllMoviesForCustomer(){
		LOGGER.info("Start");
		List<Movie> movies = movieRepository.findMoviesForCustomer();
		LOGGER.debug("movies {}", movies);
		LOGGER.info("End");
		return movies;
		
	}
	
	public List<Movie> getAllFavoritesMovie(User user){
		LOGGER.info("Start");
		List<Favorities> favorites = user.getFavorites();
		List<Movie> movies = new ArrayList<>();
		for(Favorities f : favorites) {
			movies.add(f.getMovie());
		}
		return movies;
		
	}
	
	public Favorities addToFavorites(User user,int mId) throws MovieNotFoundException {
		Optional<Movie> movie = movieRepository.findById(mId);
		if(movie.isPresent()) {
			Favorities favorities = new Favorities(user, movie.get());
			favoritiesRepository.save(favorities);
			return favorities;
		}
		throw new MovieNotFoundException("no movie present with id "+ mId);
	}
		
	

	public boolean removeFromFavorities(User user, int mId) throws MovieNotFoundException {
		Optional<Movie> movie = movieRepository.findById(mId);
		if (movie.isPresent()) {
			Favorities favorities = favoritiesRepository.findByUserAndMovieFavorities(movie.get(), user);
			System.out.println(user.getFavorites().remove(favorities));
			userRepository.save(user);
			System.out.println(user.getFavorites());
			userRepository.flush();
			return true;
		}
		throw new MovieNotFoundException("no movie present with id " + mId);
	}
	
	public User getUser() {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = userDetails.getUsername();
		for(User u: userRepository.findAll()) {
			if(u.getAuthUser().getUsername().equalsIgnoreCase(username))
				return u;
		}
		return null;
	}
	
	public User createUser(User user) {
		userRepository.save(user);
		return user;
	}
}

