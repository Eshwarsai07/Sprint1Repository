package com.multiplex.bookingsystem.movies.movieservice;

import java.util.List;

import com.multiplex.bookingsystem.movies.entity.Movies;
import com.multiplex.bookingsystem.movies.entity.Shows;

public interface MovieService {

	public void addMovies(Movies movies);

	public List<Movies> getMovies();

	public Movies getMovieByName(String movieName);

	public Shows getShowByName(String showName);

	

}
