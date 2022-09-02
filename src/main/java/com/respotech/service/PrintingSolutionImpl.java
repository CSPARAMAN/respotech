package com.respotech.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.respotech.entity.PrintingSolution;
import com.respotech.repository.PrintingSolutionRepo;
@Service
public class PrintingSolutionImpl implements PrintingSolutionService {
	@Autowired
	private PrintingSolutionRepo repo;

	@Override
	public List<PrintingSolution> getAllPrintingSoltion() {
		List<PrintingSolution> list = (List<PrintingSolution>) repo.findAll();
		return list;
	}

	@Override
	public boolean addPrintingSolution(PrintingSolution printingSolution) {
		PrintingSolution solution = repo.save(printingSolution);
		if (solution != null) {
			return true;
		}

		return false;
	}

	@Override
	public boolean updatePrintingSolution(PrintingSolution printingSolution) {
		Optional<PrintingSolution> solution = repo.findById(printingSolution.getPrintingId());

		if (solution != null) {
			PrintingSolution solution2 = repo.save(printingSolution);
			return true;
		}

		return false;
	}

	@Override
	public boolean deletePrintingSolution(int printingId) {
		repo.deleteById(printingId);
		return true;
	}

}
