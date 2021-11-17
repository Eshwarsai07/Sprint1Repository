package com.multiplex.bookingsystem.booking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.multiplex.bookingsystem.movies.entity.SeatTypes;
import com.multiplex.bookingsystem.movies.entity.Shows;
import com.multiplex.bookingsystem.users.entity.Users;

@Entity
public class Bookings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookingId;
	@OneToOne
	private Shows shows;
	@OneToOne
	private Users user;
	@OneToOne
	private SeatTypes seattypes;
	private String showName;
	private String numberOfSeats;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public Shows getShows() {
		return shows;
	}

	public void setShows(Shows shows) {
		this.shows = shows;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public String getNumberOfSeats() {
		return numberOfSeats;
	}

	public void setNumberOfSeats(String numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	public SeatTypes getSeattypes() {
		return seattypes;
	}

	public void setSeattypes(SeatTypes seattypes) {
		this.seattypes = seattypes;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", shows=" + shows + ", user=" + user + ", showName=" + showName
				+ ", numberOfSeats=" + numberOfSeats + "]";
	}

}
