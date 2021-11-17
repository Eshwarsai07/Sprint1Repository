package com.multiplex.bookingsystem.movies.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SeatTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int seatTypeId;
	private String seatTypeDesc;
	private float fare;

	public int getSeatTypeId() {
		return seatTypeId;
	}

	public void setSeatTypeId(int seatTypeId) {
		this.seatTypeId = seatTypeId;
	}

	public String getSeatTypeDesc() {
		return seatTypeDesc;
	}

	public void setSeatTypeDesc(String seatTypeDesc) {
		this.seatTypeDesc = seatTypeDesc;
	}

	public float getFare() {
		return fare;
	}

	public void setFare(float fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "SeatTypes [seatTypeId=" + seatTypeId + ", seatTypeDesc=" + seatTypeDesc + ", fare=" + fare + "]";
	}

}
