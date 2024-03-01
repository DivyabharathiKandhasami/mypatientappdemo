package com.meeshomanage.demoenum.serv;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import org.hibernate.usertype.UserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.meeshomanage.demoenum.entity.Patient;
import com.meeshomanage.demoenum.entity.User;
import com.meeshomanage.demoenum.repo.UserRepo;
import jakarta.persistence.EntityExistsException;

@Service
public class UserService {
	@Autowired
	UserRepo userrepo;
	
	public User saveUser(User user)  {
		//Optional<User> existingUser = userrepo.findByEmailId(user.getEmailId());
		//if (existingUser.isPresent()) {
		//throw new EntityExistsException("User with Email ID:" +user.getEmailId() + " already exists.");
		//}
		return userrepo.save(user);
	}
		
		public List <User> getAdminUsers()
		{
	    Set<String> adminTypes = new HashSet<>();
	    adminTypes.add("Admin");
	    return userrepo.findAllByUserTypesIn(adminTypes);	
    	}

		public List<User> getDoctorUsers()
		{
		Set <String> doctypes = new HashSet<>();
		doctypes.add("Doctor");
		return userrepo.findAllByUserTypesIn(doctypes);
		}
		
		public List<User> getReceptists() {
		Set <String> receptypes = new HashSet<>();
		receptypes.add("Receptionist");
		return userrepo.findAllByUserTypesIn(receptypes);
		} 
		
		public List<User> getPatient() {
			Set <String> patienttypes = new HashSet<>();
			patienttypes.add("Receptionist");
			return userrepo.findAllByUserTypesIn(patienttypes);
			}
		
		
		
		

}
