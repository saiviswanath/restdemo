package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="rooms")
public class RoomsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	@Column (name = "name")
	private String name;
	@Column (name = "no_seats")
	private int noSeats;
	@OneToMany(mappedBy = "rooms", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonManagedReference(value = "rooms-mov")
	private List<ScreeningsEntity> screenings;
	
	public List<ScreeningsEntity> getScreenings() {
		return screenings;
	}
	public void setScreenings(List<ScreeningsEntity> screenings) {
		this.screenings = screenings;
	}
	
	public RoomsEntity() {
	}
	public RoomsEntity(String name, int noSeats) {
		this.name = name;
		this.noSeats = noSeats;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNoSeats() {
		return noSeats;
	}
	public void setNoSeats(int noSeats) {
		this.noSeats = noSeats;
	}
	
	
}
