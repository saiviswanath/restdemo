package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.FilmsEntity;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.FilmsRepository;

@RestController
@RequestMapping("/api/v1")
public class FilmsController {
	@Autowired
	private FilmsRepository filmsRepository;
	
	@PostMapping("/films")
	public FilmsEntity addFilm(@RequestBody FilmsEntity films) {
		return filmsRepository.saveAndFlush(films);
	}
	
	@PutMapping("/films")
	public FilmsEntity updateFilm(@RequestBody FilmsEntity films) throws CustomException {
		Optional<FilmsEntity> optional = filmsRepository.findById(films.getId());
		if (optional.isPresent()) {
			return filmsRepository.saveAndFlush(films);
		}
		else {
			throw new CustomException("No Entry");
		}
	} 
	
	@GetMapping("/films")
	public List<FilmsEntity> findAllFilms() {
		return filmsRepository.findAll();
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/films/{filmId}")
	public void deleteFilm(@PathVariable int filmId) throws CustomException  {
		Optional<FilmsEntity> optional = filmsRepository.findById(filmId);
		if (optional.isPresent()) {
			filmsRepository.deleteById(filmId);
		}
		else {
			throw new CustomException("No Delete");
		}
	}
}
