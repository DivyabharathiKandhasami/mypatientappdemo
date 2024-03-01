package com.meeshomanage.demoenum.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meeshomanage.demoenum.entity.Prescription;
@Repository
public interface PresReportRepo extends JpaRepository <Prescription,Long >{

	Optional<Prescription> findById(Long patientId);
	
}
