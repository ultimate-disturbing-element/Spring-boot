package com.spring.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.spring.demo.entities.User;

public interface UserRepository extends CrudRepository<User , Integer> {
	

}
