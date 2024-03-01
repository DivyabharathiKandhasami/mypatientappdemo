package com.meeshomanage.demoenum.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meeshomanage.demoenum.entity.Patient;
@Repository
public interface PatientRepo extends JpaRepository <Patient,Long>{

	Patient save(Patient patient);

	Optional<Patient> findByPhoneNo(Long phoneNo);
    


}
