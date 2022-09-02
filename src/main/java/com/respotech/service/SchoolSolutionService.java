package com.respotech.service;

import java.util.List;

import com.respotech.entity.SchoolSolution;

public interface SchoolSolutionService {

	public List<SchoolSolution> getAllBatchDetails();

	public boolean addBatchDetials(SchoolSolution batchDetails);

	public boolean updateBatchDetails(SchoolSolution batchDetails);

	public boolean deleteBatchDetails(int batchId);
}
