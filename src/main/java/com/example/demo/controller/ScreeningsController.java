package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FilmsEntity;
import com.example.demo.entity.RoomsEntity;
import com.example.demo.entity.ScreeningsEntity;
import com.example.demo.repository.FilmsRepository;
import com.example.demo.repository.RoomsRepository;
import com.example.demo.repository.ScreeningsRepository;

@RestController
@RequestMapping("/api/v1")
public class ScreeningsController {
	@Autowired
	private ScreeningsRepository screeningsRepository;
	@Autowired
	private FilmsRepository filmsRepository;
	@Autowired
	private RoomsRepository roomsRepository;
	
	@PostMapping("/screenings/{filmId}/{roomId}")
	public ScreeningsEntity addScreening(@PathVariable int filmId, @PathVariable int roomId, @RequestBody ScreeningsEntity screenings) {
		FilmsEntity fentity = filmsRepository.findById(filmId).orElse(null);
		RoomsEntity rentity = roomsRepository.findById(roomId).orElse(null);
		//FilmsEntity entity = new FilmsEntity();
		//entity.setId(filmId);
		screenings.setFilms(fentity);
		screenings.setRooms(rentity);
		return screeningsRepository.saveAndFlush(screenings);
	}
	
	@GetMapping("/screenings")
	public List<ScreeningsEntity> findAllScreenings() {
		return screeningsRepository.findAll();
	}
}
