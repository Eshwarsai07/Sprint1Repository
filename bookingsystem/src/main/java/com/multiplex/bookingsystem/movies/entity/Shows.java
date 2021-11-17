package com.multiplex.bookingsystem.movies.entity;

import java.util.List;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Shows {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int showId;
	private String showName;

	@OneToMany(targetEntity = Halls.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "show_id", referencedColumnName = "showId")
	private List<Halls> halls;

	public int getShowId() {
		return showId;
	}

	public void setShowId(int showId) {
		this.showId = showId;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public List<Halls> getHalls() {
		return halls;
	}

	public void setHalls(List<Halls> halls) {
		this.halls = halls;
	}

	@Override
	public String toString() {
		return "Shows [showId=" + showId + ", showName=" + showName + ", halls=" + halls + "]";
	}

}
