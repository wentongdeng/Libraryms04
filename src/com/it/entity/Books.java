package com.it.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Books entity. @author MyEclipse Persistence Tools
 */

public class Books implements java.io.Serializable {

	// Fields

	private Integer id;
	private Smalltype smalltype;
	private Press press;
	private String bookName;
	private String bookNum;
	private String bookPosition;
	private Integer bookCount;
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public Books() {
	}

	/** minimal constructor */
	public Books(Smalltype smalltype, Press press, String bookName, String bookNum, String bookPosition,
			Integer bookCount) {
		this.smalltype = smalltype;
		this.press = press;
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.bookPosition = bookPosition;
		this.bookCount = bookCount;
	}

	/** full constructor */
	public Books(Smalltype smalltype, Press press, String bookName, String bookNum, String bookPosition,
			Integer bookCount, Set borrows) {
		this.smalltype = smalltype;
		this.press = press;
		this.bookName = bookName;
		this.bookNum = bookNum;
		this.bookPosition = bookPosition;
		this.bookCount = bookCount;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Smalltype getSmalltype() {
		return this.smalltype;
	}

	public void setSmalltype(Smalltype smalltype) {
		this.smalltype = smalltype;
	}

	public Press getPress() {
		return this.press;
	}

	public void setPress(Press press) {
		this.press = press;
	}

	public String getBookName() {
		return this.bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookNum() {
		return this.bookNum;
	}

	public void setBookNum(String bookNum) {
		this.bookNum = bookNum;
	}

	public String getBookPosition() {
		return this.bookPosition;
	}

	public void setBookPosition(String bookPosition) {
		this.bookPosition = bookPosition;
	}

	public Integer getBookCount() {
		return this.bookCount;
	}

	public void setBookCount(Integer bookCount) {
		this.bookCount = bookCount;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

}