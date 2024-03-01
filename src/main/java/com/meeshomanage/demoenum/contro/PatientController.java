package com.meeshomanage.demoenum.contro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.meeshomanage.demoenum.entity.Patient;
import com.meeshomanage.demoenum.serv.PatientService;

import jakarta.persistence.EntityExistsException;

@RestController
@RequestMapping("/api/patients")
public class PatientController {

	@Autowired
	private PatientService patientservice;

	@PostMapping("/post/patient")
	public ResponseEntity<Patient> savePatient(@RequestBody Patient patient) throws EntityExistsException {
		Patient savedPatient = patientservice.savePatient(patient);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedPatient);
	}

	@PutMapping("/update/patient/{id}")
	public ResponseEntity<Patient> updatePatient(@PathVariable Long id, @RequestBody Patient patient)
	throws EntityExistsException
	{
	Patient updatedPatient = patientservice.updatePatient(id, patient);
	return ResponseEntity.ok(updatedPatient);
	}

	@DeleteMapping("/delete/patient/{id}")
	public ResponseEntity<Void> deletePatient(@PathVariable Long id) throws EntityExistsException {
		patientservice.deletePatient(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/getall/patients")
	public List<Patient> getAllPatients() {
		return patientservice.getAllPatients();
	}

	@GetMapping("/getById/patients/{id}")
	public Optional<Patient> getPatientById(Long id) {
		return patientservice.getPatientById(id);
	}
}
