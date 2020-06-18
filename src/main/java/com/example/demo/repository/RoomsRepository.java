package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.RoomsEntity;

public interface RoomsRepository extends JpaRepository<RoomsEntity, Integer> {

}
