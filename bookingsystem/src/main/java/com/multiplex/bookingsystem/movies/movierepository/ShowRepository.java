package com.multiplex.bookingsystem.movies.movierepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiplex.bookingsystem.movies.entity.Shows;

@Repository
public interface ShowRepository extends JpaRepository<Shows, Integer> {

	public Shows getShowByShowName(String showName);

}
