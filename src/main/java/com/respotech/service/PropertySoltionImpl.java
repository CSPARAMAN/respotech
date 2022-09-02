package com.respotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respotech.entity.PropertySolution;
import com.respotech.repository.PropertySolutionRepo;

@Service
public class PropertySoltionImpl implements PropertySolutionService {
	@Autowired
	private PropertySolutionRepo repo;

	@Override
	public List<PropertySolution> getAllProperty() {
		List<PropertySolution> list = (List<PropertySolution>) repo.findAll();
		return list;
	}

	@Override
	public boolean addProperty(PropertySolution propertySolution) {
		PropertySolution propertySolution2 = repo.save(propertySolution);
		if (propertySolution2 != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateProperty(PropertySolution propertySolution) {
		Optional<PropertySolution> details = repo.findById(propertySolution.getPropertyId());
		if (details.isPresent()) {
			PropertySolution solution=repo.save(propertySolution);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteProperty(int propertyId) {
		repo.deleteById(propertyId);
		
		return true;
	}

}
