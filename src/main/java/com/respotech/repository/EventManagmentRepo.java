package com.respotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.respotech.entity.EventManagment;

public interface EventManagmentRepo extends JpaRepository<EventManagment, Integer> {

}
