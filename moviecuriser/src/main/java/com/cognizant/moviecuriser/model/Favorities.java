package com.cognizant.moviecuriser.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.NoArgsConstructor;
@NoArgsConstructor
@Entity
@Table(name = "favorities")
public class Favorities {
	@Id
	@Column(name = "fav_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	@JoinColumn(name = "fav_us_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "fav_mo_id")
	private Movie movie;

	

	public Favorities(User user, Movie movie) {
		super();
		this.user = user;
		this.movie = movie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}