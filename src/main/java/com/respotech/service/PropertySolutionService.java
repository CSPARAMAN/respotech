package com.respotech.service;

import java.util.List;

import com.respotech.entity.PropertySolution;

public interface PropertySolutionService {
	
	public List<PropertySolution> getAllProperty();

	public boolean addProperty(PropertySolution propertySolution);

	public boolean updateProperty(PropertySolution propertySolution);

	public boolean deleteProperty(int propertyId);

}
