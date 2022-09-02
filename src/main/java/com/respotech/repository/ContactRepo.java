package com.respotech.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.respotech.entity.ContactDetails;

public interface ContactRepo extends JpaRepository<ContactDetails, Integer> {

}
