package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.DemoEntity;
import com.example.demo.exception.CustomException;
import com.example.demo.repository.DemoRepository;

@RestController
@RequestMapping("/api/v1")
public class DemoController {
	
	@Autowired
	private DemoRepository repository;

	@GetMapping("/demos")
	//@PreAuthorize("#oauth2.hasScope('custom_mod')")
	public List<DemoEntity> demos() {
		//throw new CustomException("Debug Internal error");
		return repository.findAll();
	}
	
	@PostMapping("/postvalid")
	public DemoEntity postRequest(@Valid @RequestBody DemoEntity requestBody) {
		return repository.save(requestBody);
	}
}
