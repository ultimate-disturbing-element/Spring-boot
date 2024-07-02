package com.smartcontactmanager.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.smartcontactmanager.entities.User;
	
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User,Integer> {
	@Query("select u from User u where u.email=:email")
	public User getuserByUsername(@Param("email") String email);
}
 