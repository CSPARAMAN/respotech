package com.respotech.service;

import java.util.List;

import com.respotech.entity.ContactDetails;

public interface ContactService {
	
	public List<ContactDetails> getAllContact();
	public boolean addContact(ContactDetails contactDetails);
	public boolean deleteContact(int contactID);

}
