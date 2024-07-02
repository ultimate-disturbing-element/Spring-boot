package com.springrestapi.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.springrestapi.demo.dao.BookRepository;
import com.springrestapi.demo.entities.Book;

import java.util.*;
import java.util.stream.Collectors; 

@Component
public class BookService {
	
//	private static List<Book> list = new ArrayList<>();
//	
//	static {
//		
//		list.add(new Book(1,"java","xyz"));
//		list.add(new Book(2,"python","abc"));
//		list.add(new Book(3,"Javascript","pqr"));
//		
//	}
//	
//	Get All Books
//	public List<Book> getAllBooks(){
//		return list;
//	}
	
//	Get Single Book by Id
//	public Book getBookById(int id) {
//		Book book = null;
//		book = list.stream().filter(e->e.getId() == id).findFirst().get();
//		
//		return book;
//	}
	
//	Add Book
//	public Book addBook(Book b) {
//		list.add(b);
//		return b;
//	}
	
//	Delete Book
//	public void deleteBook(int bid) {
//		list.stream().filter(e->{
//			if(e.getId() != bid) {
//				return true;
//			}else {
//				return false;
//			}
//		}).collect(Collectors.toList());
//	}
	
//	public void UpdateBook(Book b, int bookId) {
//		list.stream().map(v->{
//			if(v.getId() == bookId) {
//				v.setTitle(b.getTitle());
//			}
//			return v;
//		}).collect(Collectors.toList());
//	}
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;	
	}
	
	public Book addBook(Book b) {
		bookRepository.save(b);
		return b;
	}
	
	
	
	

}
