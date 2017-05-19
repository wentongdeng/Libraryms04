package com.it.entity;

import java.sql.Timestamp;



/**
 * MyBorrow entity. @author MyEclipse Persistence Tools
 */

public class MyBorrow implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Books books;
	private Press press;
	private Timestamp borrowDate;
	private Timestamp returnDate;

	// Constructors

	/** default constructor */
	public MyBorrow() {
	}

	/** minimal constructor */
	public MyBorrow(User user, Books books, Press press) {
		this.user = user;
		this.books = books;
		this.press = press;
	}

	/** full constructor */
	public MyBorrow(User user, Books books, Press press, Timestamp borrowDate, Timestamp returnDate) {
		this.user = user;
		this.books = books;
		this.press = press;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
	}
	public MyBorrow(User user, Books books, Press press, Timestamp borrowDate) {
		this.user = user;
		this.books = books;
		this.press = press;
		this.borrowDate = borrowDate;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Books getBooks() {
		return this.books;
	}

	public void setBooks(Books books) {
		this.books = books;
	}

	public Press getPress() {
		return this.press;
	}

	public void setPress(Press press) {
		this.press = press;
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