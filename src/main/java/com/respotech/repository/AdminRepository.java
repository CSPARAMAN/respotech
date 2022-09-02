package com.respotech.repository;

import org.springframework.data.repository.CrudRepository;

import com.respotech.entity.Admin;

public interface AdminRepository extends CrudRepository<Admin, Integer>{
	public Admin findByAdminEmail(String adminEmail); 

}
