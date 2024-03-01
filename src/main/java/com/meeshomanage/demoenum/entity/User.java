package com.meeshomanage.demoenum.entity;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Transactional
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Setter
@Table(name="user2")
public class User {
 @Id
 @GeneratedValue(strategy=GenerationType.SEQUENCE)
 
 @Column(name="user_id")
 private Long userId;

 @Column(name="fir_name")
 private String firstName;
 
 @Column(name="las_name")
 private String lastName;
 
 @Column(name="password")
 private String password;
 
 @Column(name="con_pass")
 private String confirmPassword;
 
 @Column(name="emailId")
 private String emailId;

 @ElementCollection(targetClass = UserType.class)
 @CollectionTable(name = "UserType",joinColumns = @JoinColumn(name ="user_id"))
 @Column(name = "user_type")
 @Enumerated(EnumType.STRING)
 private Set<UserType> userTypes = new HashSet<>();
 
 //getters and setters 

 public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getConfirmPassword() {
	return confirmPassword;
}
public void setConfirmPassword(String confirmPassword) {
	this.confirmPassword = confirmPassword;
}
public String getEmailId() {
	return emailId;
}
public void setEmailId(String emailId) {
	this.emailId = emailId;
}
public Set<UserType> getUserTypes() {
	return userTypes;
}
public void setUserTypes(Set<UserType> userTypes) {
	this.userTypes = userTypes;
}

 public enum UserType
{
	Admin, Doctor, Patient, Receptionist, Pharmacist
}
 

 
 
 
 
 
 
 
 
 
 

}
