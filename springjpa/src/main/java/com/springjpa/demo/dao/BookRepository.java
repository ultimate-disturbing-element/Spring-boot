package com.springjpa.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.springjpa.demo.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

	public List<Book> findByBookname(String name);
	
	@Query("select b from Book b")
	public List<Book> getAllUser();
	
	@Query("select b from Book b where b.author = :n")
	public List<Book> fetchBookviaAuthor(@Param("n") String name);
	
	@Query(value="select * from book where author='James Clear'",nativeQuery=true)
	public List<Book> fetchBookByAuthor();
	
	
	
}
