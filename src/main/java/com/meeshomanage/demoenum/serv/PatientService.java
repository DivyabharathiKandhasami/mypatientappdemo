package com.meeshomanage.demoenum.serv;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeshomanage.demoenum.entity.Patient;
import com.meeshomanage.demoenum.repo.PatientRepo;
import jakarta.persistence.EntityExistsException;

     @Service
	 public class PatientService { 
	@Autowired
	PatientRepo patientrepo;

		public Patient savePatient(Patient patient) throws EntityExistsException {
			Optional<Patient> existingPatient = patientrepo.findByPhoneNo(patient.getPhoneNo());
			if (existingPatient.isPresent()) {
				throw new EntityExistsException("Patient with phone number" + patient.getPhoneNo() + " already exists.");
		}
		return patientrepo.save(patient);
		}

		public Patient updatePatient(Long id, Patient patient) throws EntityExistsException {
			Optional<Patient> existingPatient = patientrepo.findById(id);
			if (!existingPatient.isPresent())
			{
				throw new EntityExistsException("Patient with id " + id + " not found.");
			}
			patient.setPatientId(id);
			return patientrepo.save(patient);
		}

		public void deletePatient(Long id) throws EntityExistsException {
			Optional<Patient> existingPatient = patientrepo.findById(id);
			if (!existingPatient.isPresent()){
				throw new EntityExistsException("Patient with id " + id + " not found.");
			}

			patientrepo.deleteById(id);
		}

		public List <Patient> getAllPatients() {
			return patientrepo.findAll();
		}

		public Optional<Patient> getPatientById(Long id)
		{
			return patientrepo.findById(id);
		}

		

	}

