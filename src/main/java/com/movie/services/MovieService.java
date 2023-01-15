package com.movie.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.entites.Movie;
import com.movie.repository.MovieRepository;

@Service
public class  MovieService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	
	//get all movies
	
	public List<Movie> getAllMovies(){
		
		List<Movie> list =(List<Movie>)this.movieRepository.findAll();
		return list;
	}
	
	
	//Adding the Movie
	public Movie addMovie(Movie m)
	{
		Movie result =movieRepository.save(m);
		return result;
	}

}
