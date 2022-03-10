package com.cognizant.moviecuriser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.moviecuriser.model.Favorities;
import com.cognizant.moviecuriser.model.Movie;
import com.cognizant.moviecuriser.model.User;

@Repository
public interface FavoritiesRepository extends JpaRepository<Favorities, Integer> {

	//write the query fetching fav-mv-id based on movie obj using @Query
	//@Query("select f.id from  Favorities f where movie=?1")
	//int findByMovieId(Movie m);
	// write the query to delete based on f.id and fav_us_i = 1001 using @Query
	//@Query(value = "select * from Movie where mo_id=:n",nativeQuery = true)
	//public int deleteByMovie(@Param("n") int id);
	
	@Query("select fav from Favorities fav where movie=?1 and user=?2")
	Favorities findByUserAndMovieFavorities(Movie movie, User user); 
	
	@Query("delete from Favorities fav where fav=?1")
	void deleteFavorities(Favorities f);
}
