package com.respotech.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class ContactDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int contactID;
	private String fullName;
	private String email;
	private String msg;
	private Long phoneNo;
	
                                                      	

}
