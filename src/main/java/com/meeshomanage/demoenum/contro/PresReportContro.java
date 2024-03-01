package com.meeshomanage.demoenum.contro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meeshomanage.demoenum.entity.Prescription;
import com.meeshomanage.demoenum.serv.PresReportService;

import jakarta.persistence.EntityExistsException;


@Controller
@RestController
@RequestMapping("/api/presreport")
public class PresReportContro{
	@Autowired
	private PresReportService presreportservice;
	@PostMapping("/post/prescription")
	public ResponseEntity<Prescription> savePrescription(@RequestBody Prescription prescription) throws EntityExistsException {
		Prescription savedPatient = presreportservice.savePrescription(prescription);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
	}
	
	@PutMapping("/update/patient/{id}")
	public ResponseEntity<Prescription> updatePrescription(@PathVariable Long id, @RequestBody Prescription prescription)
	throws EntityExistsException
	{
	Prescription updatedPres =  presreportservice.updatePrescription(id, prescription);
	return ResponseEntity.ok(updatedPres );
	}
	
	
}
