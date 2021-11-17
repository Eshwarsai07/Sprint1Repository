package com.multiplex.bookingsystem.booking.bookingcontroller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.multiplex.bookingsystem.booking.entity.Bookings;
import com.multiplex.bookingsystem.booking.service.BookingService;
import com.multiplex.bookingsystem.movies.entity.Halls;
import com.multiplex.bookingsystem.movies.entity.Movies;
import com.multiplex.bookingsystem.movies.entity.SeatTypes;
import com.multiplex.bookingsystem.movies.entity.Shows;
import com.multiplex.bookingsystem.movies.movieservice.MovieService;
import com.multiplex.bookingsystem.users.entity.Users;
import com.multiplex.bookingsystem.users.service.UserService;

@Controller
public class BookingController {
	@Autowired
	MovieService service;
	@Autowired
	UserService userservice;
	@Autowired
	BookingService bookingservice;

	@GetMapping("/AMB/booking")
	public String book() {
		return "bookingview";
	}

	@PostMapping("/AMB/booked")
	public String booked(HttpServletRequest req, Model m) {

		Bookings booking = new Bookings();
		int point = 0;
		String username = req.getParameter("userName");
		String moviename = req.getParameter("movieName");
		String showname = req.getParameter("showName");
		String numberofseats = req.getParameter("numberOfSeats");
		String hallname = req.getParameter("hallName");
		String seattype = req.getParameter("seatType");
		Shows s1 = new Shows();
		Users u = new Users();
		int capacity;
		SeatTypes seatType = null;

		Movies m1 = service.getMovieByName(moviename);
		
		List<Shows> shows = m1.getShows();
		for (Shows s : shows) {
			if (s.getShowName().equals(showname)) {
				s1 = s;
				point = 1;
			}
		}
		if (point == 0)
			return "bookingfailed";
		else if (m1 == null)
			return "bookingfailed";
		else {
			booking.setNumberOfSeats(numberofseats);
			booking.setShowName(showname);
			List<Halls> halls = s1.getHalls();
			for (Halls h : halls) {
				if (h.getHallDesc().equals(hallname)) {
					List<SeatTypes> seatTypes = h.getSeatTypes();
					for (SeatTypes seats : seatTypes) {
						if (seats.getSeatTypeDesc().equals(seattype)) {
							if (seattype.equals("FirstClass")) {
								seatType=seats;
								capacity = h.getFirstClassAvailableSeats();
								int a = Integer.parseInt(numberofseats);
								h.setFirstClassAvailableSeats(capacity - a);
							} else {
								seatType=seats;
								capacity = h.getBalconyAvailableSeats();
								int a = Integer.parseInt(numberofseats);
								h.setBalconyAvailableSeats(capacity - a);
							}
						}
					}
				}

			}
			booking.setShows(s1);
			u = userservice.getUser(username);
			booking.setUser(u);
			booking.setSeattypes(seatType);
			bookingservice.addBooking(booking);

			m.addAttribute("bookingid", booking.getBookingId());
			return "bookingsuccess";

		}
	}

	@GetMapping("/AMB/bookingdetails")
	public String bookingDetailsPage() {
		return "bookingdetailspage";

	}

	@PostMapping("/AMB/details")
	public String bookDetails(HttpServletRequest req, Model m) {
		String a = req.getParameter("bookingId");
		int id = Integer.parseInt(a);
		Optional<Bookings> bookings = bookingservice.getBooking(id);
		if (bookings.isPresent()) {

			String seats = bookings.get().getNumberOfSeats();
			String show = bookings.get().getShowName();
			SeatTypes seattype=bookings.get().getSeattypes();
			String seatdesc=seattype.getSeatTypeDesc();
			float fare=seattype.getFare();
			Users u = bookings.get().getUser();
			String bookedby = u.getUserName();
			m.addAttribute("seats", seats);
			m.addAttribute("show", show);
			m.addAttribute("bookedBy", bookedby);
			m.addAttribute("seatdesc", seatdesc);
			m.addAttribute("fare", fare);
			return "bookingdetailsview";
		} else
			return "failed";

	}

}
