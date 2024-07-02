package com.springjpa.demo.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String bookname;
	private int price;
	private String author;
	
	
	public Book(int id, String bookname, int price, String author) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
	}
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String book_name) {
		this.bookname = book_name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}


	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", price=" + price + ", author=" + author + "]";
	}
	

}
