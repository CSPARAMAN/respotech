package com.respotech.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.respotech.entity.Admin;
import com.respotech.entity.MyAdminDetails;
import com.respotech.repository.AdminRepository;
@Service
public class AdminImpl  implements UserDetailsService{
	
    @Autowired
	private AdminRepository adminRepository;
    
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	                           Admin admin=adminRepository.findByAdminEmail(username);
	  if(admin!=null) {
		  return new MyAdminDetails(admin);
	  }throw new UsernameNotFoundException("user not found");
		  
	  
	}
	
	public Admin addData(Admin admin) {
		return adminRepository.save(admin);
	}

}
