package com.springrestapi.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.springrestapi.demo.entities.Book;

public interface BookRepository extends CrudRepository<Book,Integer> {
	
	public Book findById(int id);

}
