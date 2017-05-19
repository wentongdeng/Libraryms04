package com.it.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Short admin;
	private String userName;
	private String userPass;
	private String userUnit;
	private Integer loadcount;
	private Set borrows = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(Short admin, String userName, String userPass) {
		this.admin = admin;
		this.userName = userName;
		this.userPass = userPass;
	}

	/** full constructor */
	public User(Short admin, String userName, String userPass, String userUnit, Integer loadcount, Set borrows) {
		this.admin = admin;
		this.userName = userName;
		this.userPass = userPass;
		this.userUnit = userUnit;
		this.loadcount = loadcount;
		this.borrows = borrows;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Short getAdmin() {
		return this.admin;
	}

	public void setAdmin(Short admin) {
		this.admin = admin;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public String getUserUnit() {
		return this.userUnit;
	}

	public void setUserUnit(String userUnit) {
		this.userUnit = userUnit;
	}

	public Integer getLoadcount() {
		return this.loadcount;
	}

	public void setLoadcount(Integer loadcount) {
		this.loadcount = loadcount;
	}

	public Set getBorrows() {
		return this.borrows;
	}

	public void setBorrows(Set borrows) {
		this.borrows = borrows;
	}

}