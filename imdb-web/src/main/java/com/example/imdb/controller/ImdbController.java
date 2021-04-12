package com.example.imdb.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.example.imdb.domain.Movie;
import com.example.imdb.service.MovieService;

@RestController
@RequestScope
@RequestMapping("movies")
@CrossOrigin
public class ImdbController {
	//@Autowired
	private MovieService movieSrv;
	
	public ImdbController(MovieService movieSrv) {
		this.movieSrv = movieSrv;
	}

	// localhost:9001/imdb/api/v1 -> application.properties
	// http://localhost:9001/imdb/api/v1/movies?fromYear=1970&toYear=1979 , query parameter
	@GetMapping(params = {"fromYear","toYear"})
	public Collection<Movie> getMoviesByYearRange(@RequestParam int fromYear,@RequestParam int toYear) {
		System.err.println(movieSrv.getClass().getName());
		return movieSrv.findAllMoviesByYearRange(fromYear, toYear);
	}
}
