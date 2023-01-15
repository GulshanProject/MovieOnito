package com.movie.repository;

import org.springframework.data.repository.CrudRepository;

import com.movie.entites.Movie;

public interface MovieRepository extends CrudRepository<Movie, String>{
	
	public Movie findBytconst(String tconst);

}
