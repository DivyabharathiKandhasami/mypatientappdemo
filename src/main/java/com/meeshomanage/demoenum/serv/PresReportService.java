package com.meeshomanage.demoenum.serv;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.meeshomanage.demoenum.entity.Prescription;
import com.meeshomanage.demoenum.repo.PresReportRepo;

import jakarta.persistence.EntityExistsException;

@Service
public class PresReportService {
	@Autowired
	PresReportRepo presreportrepo;

	public Prescription savePrescription(Prescription prescription) throws EntityExistsException {
		Optional<Prescription> existingPatient = presreportrepo.findById(prescription.getPatientId());
		if (existingPatient.isPresent()) {
			throw new EntityExistsException("Patient with their Id" + prescription.getPatientId() + "already exists.");
		}
		return presreportrepo.save(prescription);
	}

	public Prescription updatePrescription(Long id, Prescription prescription) throws EntityExistsException {
		Optional<Prescription> existingPres = presreportrepo.findById(id);
		if (!existingPres.isPresent()) {
			throw new EntityExistsException("Patient with id " + id + " not found.");
		}
		prescription.setPatientId(id);
		return presreportrepo.save(prescription);
	}

}
