package com.springrestapi.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.demo.entities.Book;
import com.springrestapi.demo.services.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookservice;
	
//	@RequestMapping(value="/books",method=RequestMethod.GET)
	@GetMapping("/books")
//	public Book getBooks(){
//		Book book = new Book();
//		book.setId(1);
//		book.setTitle("Stranger Things");
//		book.setAuthor("Paradise");
//		
//		return book;
//		
//	}
//	public List getBooks() {
//		return this.bookservice.getAllBooks();
//	}
	public ResponseEntity<List<Book>> getBooks(){
		List<Book> list = bookservice.getAllBooks();
		if(list.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
	}
	
	
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book book) {
		Book b = this.bookservice.addBook(book);
		return b;
	}
	
//	@DeleteMapping("/books/{bookId}")
//	public void deleteBook(@PathVariable("bookId") int bookId) {
//		this.bookservice.deleteBook(bookId);
//	}
//	
//	@PutMapping("/books/{bookId}")
//	public Book updateBook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
//		 this.bookservice.UpdateBook(book, bookId);
//		 return book;
//	}

}
