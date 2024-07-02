package com.springrestapi.demo.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int authorid;
	private String firstName;
	private String  lastName;
	private String language;
	@OneToOne(mappedBy =  "author")
	@JsonBackReference
	private Book book;
	
	
	public Book getBook() {
		return book;
	}


	public void setBook(Book book) {
		this.book = book;
	}


	public Author(int id, String firstName, String lastName, String language,Book book) {
		super();
		this.authorid = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
		this.book = book;
	}
	
	
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return authorid;
	}
	public void setId(int id) {
		this.authorid = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}


	@Override
	public String toString() {
		return "Author [authorid=" + authorid + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
				+ language + ", book=" + book + "]";
	}


	

	

}
