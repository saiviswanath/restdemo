package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="films")
public class FilmsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "id")
	private int id;
	@Column (name = "name")
	private String name;
	@Column (name = "length_min")
	private int lengthMin;
	
	@OneToMany(mappedBy = "films", cascade = {CascadeType.DETACH, CascadeType.MERGE, 
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JsonManagedReference(value = "films-mov")
	private List<ScreeningsEntity> screenings;
	
	public FilmsEntity() {
	}
	public FilmsEntity(String name, int lengthMin) {
		this.name = name;
		this.lengthMin = lengthMin;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getLengthMin() {
		return lengthMin;
	}
	public void setLengthMin(int lengthMin) {
		this.lengthMin = lengthMin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public List<ScreeningsEntity> getScreenings() {
		return screenings;
	}
	public void setScreenings(List<ScreeningsEntity> screenings) {
		this.screenings = screenings;
	}
	
	
	
	
}
