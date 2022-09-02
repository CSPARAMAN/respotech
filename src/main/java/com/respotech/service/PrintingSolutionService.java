package com.respotech.service;

import java.util.List;

import com.respotech.entity.PrintingSolution;

public interface PrintingSolutionService {
	public List<PrintingSolution> getAllPrintingSoltion();

	public boolean addPrintingSolution(PrintingSolution printingSolution);

	public boolean deletePrintingSolution(int printingId);

	public boolean updatePrintingSolution(PrintingSolution printingSolution);

}
