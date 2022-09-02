package com.respotech.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respotech.entity.ContactDetails;
import com.respotech.repository.ContactRepo;
@Service
public class ContactServiceImpl implements ContactService {
	@Autowired
	private ContactRepo repo;

	@Override
	public List<ContactDetails> getAllContact() {
		List<ContactDetails> list = (List<ContactDetails>) repo.findAll();

		return list;
	}

	@Override
	public boolean addContact(ContactDetails contactDetails) {
		ContactDetails details = repo.save(contactDetails);
		if (details != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteContact(int contactID) {
		repo.deleteById(contactID);
		// TODO Auto-generated method stub
		return true;
	}

}
