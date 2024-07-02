package com.springtodo.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.springtodo.demo.entities.Task;

public interface TaskRepository extends CrudRepository<Task,Integer> {
	
	public Task findById(int id);

}
