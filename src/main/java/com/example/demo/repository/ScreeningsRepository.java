package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ScreeningsEntity;

public interface ScreeningsRepository extends JpaRepository<ScreeningsEntity, Integer> {

}
