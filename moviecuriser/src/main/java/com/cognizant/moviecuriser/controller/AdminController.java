package com.cognizant.moviecuriser.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecuriser.exception.MovieNotFoundException;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	AdminService adminService;
	
	@GetMapping("/home")
	public List<Movie> adminsHome() throws MovieNotFoundException {
			return adminService.getAllMovies();
	}
	
	@GetMapping("/movieDetails")
	public Movie getMovieDetails(@RequestParam("id") int id) {
		return adminService.getMovieDetail(id);
	}
	
	@PutMapping("/update")
	public String updateMovie(@RequestBody Movie movie) throws ParseException {
		adminService.updateMovie(movie);
		return "Updated Successfully";
	}

}
