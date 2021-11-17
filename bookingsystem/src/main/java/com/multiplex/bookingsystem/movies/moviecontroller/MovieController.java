package com.multiplex.bookingsystem.movies.moviecontroller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.multiplex.bookingsystem.movies.entity.Halls;
import com.multiplex.bookingsystem.movies.entity.Movies;
import com.multiplex.bookingsystem.movies.entity.Shows;
import com.multiplex.bookingsystem.movies.movieservice.MovieService;

@Controller
public class MovieController {
	@Autowired
	public MovieService movieservice;
	

	@PostMapping("/movies/add")
	public String addMovies(@RequestBody Movies movies) {
		movieservice.addMovies(movies);
		return "success";
	}

	@GetMapping("/AMB/movies/shows/{movieName}")
	public String getShows(@PathVariable String movieName,Model m1) {
		int point=0;
		
		Movies m = movieservice.getMovieByName(movieName);
		List<Shows> s = m.getShows();
		List<String> name=new ArrayList<String>();
		List<List<Halls>> list=new ArrayList<List<Halls>>();
		for(Shows s1:s) {
			name.add(s1.getShowName());
			list.add(s1.getHalls());
		}
		m1.addAttribute("shows", name);
		m1.addAttribute("halls", list);
		
		
		return "displayshows";
	}
	@GetMapping("/AMB/movies")
	public String getMovies(Model m1) {
		List<String> s=new ArrayList<String>();
		List<Movies> m=movieservice.getMovies();
		for(Movies mov:m) {
			s.add(mov.getMovieName());
		}
		m1.addAttribute("movies",s);
		return "displaymovies";
	}
	@GetMapping("/AMB/movies/shows/halls/{showName}")
	public String getHalls(@PathVariable String showName,Model m) {
		Movies m1=movieservice.getMovieByName("LEADER");
		List<Shows> s2=m1.getShows();
		Shows s1=new Shows();
		for(Shows s:s2) {
			if(s.getShowName().equals(showName)) {
				s1=s;
				break;
			}
		}
		//Shows s1=movieservice.getShowByName(showName);
		List<Halls> h=s1.getHalls();
		
		m.addAttribute("halls", h);
		return "displayhalls";
		
	}
	
}
	


