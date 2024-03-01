package com.meeshomanage.demoenum.contro;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.meeshomanage.demoenum.entity.User;
import com.meeshomanage.demoenum.serv.UserService;
import jakarta.persistence.EntityExistsException;
@RestController
@RequestMapping("/api/user")
public class UserController {
	@Autowired 
	UserService userservice;
	@PostMapping("/post/user")
	public ResponseEntity<User>saveUser(@RequestBody User user) throws EntityExistsException {
	User savedUser = userservice.saveUser(user);
	return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
	@GetMapping("/admins")
    public ResponseEntity <List<User>> getAdminUsers() {
    List <User> adminUsers = userservice.getAdminUsers();
    return ResponseEntity.ok(adminUsers);
    }
	@GetMapping("/doctor")
	public ResponseEntity <List<User>> getDoctorUsers(){
	List <User> doctorUsers = userservice.getDoctorUsers();
	return ResponseEntity.ok(doctorUsers);
	} 
	@GetMapping("/reception")
	public ResponseEntity <List<User>> getReceptists(){
	List <User> receptionists = userservice.getReceptists();
	return ResponseEntity.ok(receptionists);
	}
	@GetMapping("/patient")
	public ResponseEntity <List<User>> getPatient(){
	List <User> patients = userservice.getPatient();
	return ResponseEntity.ok(patients);
	}
	
	

}
