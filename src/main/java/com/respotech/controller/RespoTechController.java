package com.respotech.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.respotech.entity.SchoolSolution;
import com.respotech.jwt.JwtUtil;
import com.respotech.model.Request;
import com.respotech.model.Response;
import com.respotech.repository.SchoolSolutionRepo;
import com.respotech.entity.ContactDetails;
import com.respotech.entity.EventManagment;
import com.respotech.entity.PrintingSolution;
import com.respotech.entity.PropertySolution;
import com.respotech.service.SchoolSolutionService;
import com.respotech.service.AdminImpl;
import com.respotech.service.ContactService;
import com.respotech.service.EventManagmentService;
import com.respotech.service.PrintingSolutionService;
import com.respotech.service.PropertySolutionService;
import org.springframework.security.core.AuthenticationException;

@RestController
@CrossOrigin("*")
public class RespoTechController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtUtil;

	@Autowired
	private AdminImpl adminImpl;

	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	private SchoolSolutionService schoolService;
	@Autowired
	private PropertySolutionService propertySolutionService;
	@Autowired
	private PrintingSolutionService printingSolutionService;
	@Autowired
	private EventManagmentService service;
	@Autowired
	private ContactService contactService;
	
	// Admin .......................

		@PostMapping("/authentication")
		public Response authentication(@RequestBody Request request) throws Exception {
			Response response = new Response();

			try {
				authenticationManager.authenticate(
						new UsernamePasswordAuthenticationToken(request.getAdminEmail(), request.getAdminPassword()));
			} catch (AuthenticationException e) {
				
				//throw new Exception("invaild id and password", e);
				response.setStatuscode(401);
				response.setMsg("admin unlogged");
				return response;
				
			}
			UserDetails userDetails = userDetailsService.loadUserByUsername(request.getAdminEmail());
			String jwt = jwtUtil.generateToken(userDetails);
			response.setStatuscode(200);
			response.setMsg("admin logged");
			response.setToken(jwt);

			return response;
		}

	// School Controller....

	@GetMapping("/getAllBatch")
	public ResponseEntity<List<SchoolSolution>> getAllBatchDetails() {
		List<SchoolSolution> list = schoolService.getAllBatchDetails();
		if (list.size() > 0) {
			return ResponseEntity.of(Optional.of(list));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/addBatchDetails")
	public ResponseEntity<?> addBatchDetails(@RequestBody SchoolSolution batchDetails) {
		if (schoolService.addBatchDetials(batchDetails)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping("/updateBatchDetails")
	public ResponseEntity<?> updateBatchDetails(@RequestBody SchoolSolution batchDetails) {
		if (schoolService.updateBatchDetails(batchDetails)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}

	@DeleteMapping("/deleteBatchDetails/{id}")
	public ResponseEntity<?> deleteBatchDetails(@PathVariable int id) {
		if (schoolService.deleteBatchDetails(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// Property Solution Controller....

	@GetMapping("/getAllProperty")
	public ResponseEntity<List<PropertySolution>> getAllProperty() {
		List<PropertySolution> list = propertySolutionService.getAllProperty();
		if (list.size() > 0) {
			return ResponseEntity.of(Optional.of(list));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping("/addProject")
	public ResponseEntity<?> addProperty(@RequestBody PropertySolution propertySolution) {
		if (propertySolutionService.addProperty(propertySolution)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping("/updateProject")
	public ResponseEntity<?> updateProject(@RequestBody PropertySolution propertySolution) {
		if (propertySolutionService.updateProperty(propertySolution)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@DeleteMapping("/deleteProject/{id}")
	public ResponseEntity<?> deleteProject(@PathVariable int id) {
		if (propertySolutionService.deleteProperty(id)) {
			return ResponseEntity.status(HttpStatus.OK).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// Printing Solution....

	@GetMapping("/getAllPrinting")
	public ResponseEntity<List<PrintingSolution>> getAllPrinting() {
		List<PrintingSolution> list = printingSolutionService.getAllPrintingSoltion();
		if (list.isEmpty()) {
			return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}

	@PostMapping("/addPrintingSolution")
	public ResponseEntity<?> addPrintingSolution(@RequestBody PrintingSolution printingSolution) {
		if (printingSolutionService.addPrintingSolution(printingSolution)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();

	}

	@PutMapping("/updatePrintingSolution")
	public ResponseEntity<?> updatePrintingSolution(@RequestBody PrintingSolution printingSolution) {
		if (printingSolutionService.addPrintingSolution(printingSolution)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}

	@DeleteMapping("/printingSolution/{id}")
	public ResponseEntity<?> deletePrintingSolution(@PathVariable int id) {
		if (printingSolutionService.deletePrintingSolution(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}

	// EventManagment Solution.......

	@GetMapping("/getAllEvent")
	public ResponseEntity<List<EventManagment>> getAllEventDetails() {
		List<EventManagment> list = service.getAllEventManagment();
		if (list.size() > 0) {
			return ResponseEntity.of(Optional.of(list));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/addEventDetails")
	public ResponseEntity<?> addEventDetails(@RequestBody EventManagment eventManagment) {
		if (service.addEventManagment(eventManagment)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@PutMapping("/updateEventDetails")
	public ResponseEntity<?> updateEventDetails(@RequestBody EventManagment eventManagment) {
		if (service.updateEventManagment(eventManagment)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_GATEWAY).build();
	}

	@DeleteMapping("/deleteEventDetails/{id}")
	public ResponseEntity<?> deleteEventDetails(@PathVariable int id) {
		if (service.deleteEventManagment(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	// ContactDetails...

	@GetMapping("/getAllContact")
	public ResponseEntity<List<ContactDetails>> getAllContactDetails() {
		List<ContactDetails> list = contactService.getAllContact();
		if (list.size() > 0) {
			return ResponseEntity.of(Optional.of(list));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

	}

	@PostMapping("/addContactDetails")
	public ResponseEntity<?> addContactDetails(@RequestBody ContactDetails contactDetails) {
		if (contactService.addContact(contactDetails)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

	@DeleteMapping("/deleteContactDetails/{id}")
	public ResponseEntity<?> deleteContactDetails(@PathVariable int id) {
		if (contactService.deleteContact(id)) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}

}
