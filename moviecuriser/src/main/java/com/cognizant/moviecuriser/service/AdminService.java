package com.cognizant.moviecuriser.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecuriser.exception.MovieNotFoundException;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.repository.MovieRepository;

@Service
public class AdminService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);
	
	@Autowired
	MovieRepository movieRepository;
	
	public List<Movie> getAllMovies() throws MovieNotFoundException{
		LOGGER.info("Start");
		List<Movie> movies = movieRepository.findAll();
		LOGGER.info("End");
		return movies;
		
		
		
	}
	
	public Movie getMovieDetail(int id) {
		LOGGER.info("Start");
		Movie movie = movieRepository.findById(id).get();
		LOGGER.info("End");
		return movie;
		
	}
	
	public void updateMovie(Movie movie) {
		LOGGER.info("Start");
		movieRepository.save(movie);
		LOGGER.info("End");
	}

}
