package com.springjpa.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.springjpa.demo.dao.BookRepository;
import com.springjpa.demo.entities.Book;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);
		BookRepository bookRepository = context.getBean(BookRepository.class);
		
		Book book = new Book();
		
//		book.setBookname("Atomic Habit");
//		book.setPrice(199);
//		book.setAuthor("James Clear");
//		
//		Book book2 = new Book();
//		
//		book2.setBookname("It ends with Us");
//		book2.setPrice(145);
//		book2.setAuthor("Hover Colean");
//		
//		List<Book> books = List.of(book,book2);
//		
//		Iterable<Book> result  =bookRepository.saveAll(books);
//		
//		result.forEach(e->System.out.println(e));
		
//		Iterable<Book> result = bookRepository.findAll();
//		result.forEach(e->System.out.println(e));
//		
//		Iterable<Book> re = bookRepository.findByBookname("Atomic Habit");
//		re.forEach(e->System.out.println(e));
		
		
//		update Book
//		Optional<Book> book3 = bookRepository.findById(2);
//		Book res = book3.get();
//		
//		res.setBookname("It Start with Us");
//		
//		Book resu = bookRepository.save(res);
//		
//		System.out.println(resu);
		
		System.out.println("-------------------------------------------------");
		
//		Delete Book
//		bookRepository.deleteById(2);
		Iterable<Book> resul = bookRepository.fetchBookviaAuthor("James Clear");
		resul.forEach(e->System.out.println(e));
		
		
	}
	
	


}
