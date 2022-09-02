package com.respotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respotech.entity.SchoolSolution;
import com.respotech.repository.SchoolSolutionRepo;

@Service
public class SchoolSolutionServiceImpl implements SchoolSolutionService {

	@Autowired
	private SchoolSolutionRepo batchRepo;

	@Override
	public List<SchoolSolution> getAllBatchDetails() {
		    List<SchoolSolution> list=(List<SchoolSolution>) batchRepo.findAll();
		return list;
	}

	@Override
	public boolean addBatchDetials(SchoolSolution batchDetails) {
		SchoolSolution details = batchRepo.save(batchDetails);
		if (details != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateBatchDetails(SchoolSolution batchDetails) {
		Optional<SchoolSolution> details = batchRepo.findById(batchDetails.getBatchId());
		if (details.isPresent()) {
			SchoolSolution details2=batchRepo.save(batchDetails);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteBatchDetails(int batchId) {
		batchRepo.deleteById(batchId);
		return true;
	}

	

}
