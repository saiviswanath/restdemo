package com.example.demo.entity;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="screenings")
public class ScreeningsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH}, fetch = FetchType.LAZY)
	@JoinColumn(name = "film_id")
	@JsonBackReference(value = "films-mov")
	private FilmsEntity films;
	
	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "room_id")
	@JsonBackReference(value = "rooms-mov")
	private RoomsEntity rooms;
	
	public RoomsEntity getRooms() {
		return rooms;
	}

	public void setRooms(RoomsEntity rooms) {
		this.rooms = rooms;
	}

	@Column (name = "start_time")
	private LocalDateTime startTime;

	public ScreeningsEntity() {
	}

	public ScreeningsEntity(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public FilmsEntity getFilms() {
		return films;
	}

	public void setFilms(FilmsEntity films) {
		this.films = films;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
}
