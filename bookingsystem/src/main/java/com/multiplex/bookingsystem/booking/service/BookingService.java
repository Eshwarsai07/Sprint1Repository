package com.multiplex.bookingsystem.booking.service;

import java.util.Optional;

import com.multiplex.bookingsystem.booking.entity.Bookings;

public interface BookingService {

	public void addBooking(Bookings booking);

	public Optional<Bookings> getBooking(int id);

}
