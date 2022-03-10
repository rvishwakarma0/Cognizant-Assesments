package com.cognizant.moviecuriser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.moviecuriser.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {

	
// write the query for m.active = 'Yes' and m.dateOfLaunch < CURRENT_DATE" using @Query
	@Query("select m from Movie m WHERE m.active =true AND m.dateOfLaunch<CURRENT_DATE")
	public List<Movie> findMoviesForCustomer();
	
	
//write sub query or join query get movie details based on fav-movie-id using @Query
	@Query(value="select * from movie where mo_id in (select fav_mo_id from favorities)", nativeQuery = true)
	public List<Movie> findAllFavorites();
}
