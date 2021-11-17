package com.multiplex.bookingsystem.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.multiplex.bookingsystem.booking.entity.Bookings;

@Repository
public interface BookingRepository extends JpaRepository<Bookings, Integer> {

}
