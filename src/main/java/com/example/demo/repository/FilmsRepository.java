package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.FilmsEntity;

public interface FilmsRepository extends JpaRepository<FilmsEntity, Integer> {

}
