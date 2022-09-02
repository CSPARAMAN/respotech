package com.respotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respotech.entity.EventManagment;
import com.respotech.repository.EventManagmentRepo;
@Service
public class EventManagmentServiceImpl implements EventManagmentService {
	@Autowired
	private EventManagmentRepo repo;

	@Override
	public List<EventManagment> getAllEventManagment() {
        List<EventManagment> list=(List<EventManagment>) repo.findAll();
		return list;
	}

	@Override
	public boolean addEventManagment(EventManagment eventManagment) {
		EventManagment details=repo.save(eventManagment);
		if (details != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateEventManagment(EventManagment eventManagment) {
		Optional<EventManagment> details=repo.findById(eventManagment.getEventId());
		
		if (details != null) {
			repo.save(eventManagment);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteEventManagment(int eventId) {
		repo.deleteById(eventId);
		return true;
	}

}
