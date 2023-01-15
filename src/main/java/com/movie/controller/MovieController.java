package com.movie.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.movie.entites.Movie;
import com.movie.services.MovieService;

@RestController
public class MovieController {
	
	@Autowired
	private MovieService movieService;
	
	//get all movies controller
	
	@GetMapping("/api/v1/longest-duration-movies")
	public ResponseEntity<List<Movie>> getMovies() 
	{
		List<Movie> list = movieService.getAllMovies();
		if(list.size() <=0) {
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.ok().body(list);
	}
	
	
	
	
	
	// new book handler
	@PostMapping("/api/v1/new-movie")
	public ResponseEntity<Movie> addMovie (@RequestBody Movie movie)
	{
		Movie m=null;
		
		try {
			m=this.movieService.addMovie(movie);
			System.out.println("New movie successfully added");
			return ResponseEntity.status(HttpStatus.CREATED).body(m);
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	

}
