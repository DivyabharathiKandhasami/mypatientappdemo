package com.meeshomanage.demoenum.repo;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.hibernate.usertype.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.meeshomanage.demoenum.entity.Patient;
import com.meeshomanage.demoenum.entity.User;

@Repository
public interface UserRepo  extends JpaRepository <User, Long>   {

	User save(User user);

	Optional<User> findByEmailId(String emailId);
   // List<User> findAllByUserTypesIn(Set<UserType> userTypes);

  List<User> findAllByUserTypesIn(Set<String> adminTypes);

	

}
