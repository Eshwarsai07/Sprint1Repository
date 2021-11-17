package com.multiplex.bookingsystem.movies.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Halls {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int hallId;
	private String hallDesc;
	private int firstClassAvailableSeats;
	private int balconyAvailableSeats;
	@OneToMany(targetEntity = SeatTypes.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "hall_id", referencedColumnName = "hallId")
	private List<SeatTypes> seatTypes;

	public int getHallId() {
		return hallId;
	}

	public void setHallId(int hallId) {
		this.hallId = hallId;
	}

	public String getHallDesc() {
		return hallDesc;
	}

	public void setHallDesc(String hallDesc) {
		this.hallDesc = hallDesc;
	}

	

	

	public int getFirstClassAvailableSeats() {
		return firstClassAvailableSeats;
	}

	public void setFirstClassAvailableSeats(int firstClassAvailableSeats) {
		this.firstClassAvailableSeats = firstClassAvailableSeats;
	}

	public int getBalconyAvailableSeats() {
		return balconyAvailableSeats;
	}

	public void setBalconyAvailableSeats(int balconyAvailableSeats) {
		this.balconyAvailableSeats = balconyAvailableSeats;
	}

	public List<SeatTypes> getSeatTypes() {
		return seatTypes;
	}

	public void setSeatTypes(List<SeatTypes> seatTypes) {
		this.seatTypes = seatTypes;
	}

	@Override
	public String toString() {
		return "hallId=" + hallId + ", hallDesc=" + hallDesc + ", firstClassAvailableSeats="
				+ firstClassAvailableSeats + ", balconyAvailableSeats=" + balconyAvailableSeats;
	}

	

}
