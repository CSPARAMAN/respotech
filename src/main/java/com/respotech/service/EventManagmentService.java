package com.respotech.service;

import java.util.List;

import com.respotech.entity.EventManagment;

public interface EventManagmentService {

	public List<EventManagment> getAllEventManagment();

	public boolean addEventManagment(EventManagment eventManagment);

	public boolean updateEventManagment(EventManagment eventManagment);

	public boolean deleteEventManagment(int eventId);
}
