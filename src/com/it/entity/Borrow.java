package com.it.entity;

import java.sql.Timestamp;

/**
 * Borrow entity. @author MyEclipse Persistence Tools
 */

public class Borrow implements java.io.Serializable {

	// Fields

	private Integer id;
	private Books books;
	private User user;
	private Timestamp borrowDate;
	private Timestamp returnDate;

	// Constructors

	/** default constructor */
	public Borrow() {
	}

	/** minimal constructor */
	public Borrow(Books books, User user, Timestamp borrowDate) {
		this.books = books;
		this.user = user;
		this.borrowDate = borrowDate;
	}

	/** full constructor */
	public Borrow(Books books, User user, Timestamp borrowDate, Timestamp returnDate) {
		this.books = books;
		this.user = user;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Timestamp getBorrowDate() {
		return this.borrowDate;
	}

	public void setBorrowDate(Timestamp borrowDate) {
		this.borrowDate = borrowDate;
	}

	public Timestamp getReturnDate() {
		return this.returnDate;
	}

	public void setReturnDate(Timestamp returnDate) {
		this.returnDate = returnDate;
	}

}