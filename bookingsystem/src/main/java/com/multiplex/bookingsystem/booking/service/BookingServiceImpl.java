package com.multiplex.bookingsystem.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiplex.bookingsystem.booking.entity.Bookings;
import com.multiplex.bookingsystem.booking.repository.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {
	@Autowired
	BookingRepository rep;

	@Override
	public void addBooking(Bookings booking) {
		// TODO Auto-generated method stub
		rep.save(booking);
	}

	@Override
	public Optional<Bookings> getBooking(int id) {
		// TODO Auto-generated method stub
		return rep.findById(id);
	}

}
