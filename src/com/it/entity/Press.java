package com.it.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Press entity. @author MyEclipse Persistence Tools
 */

public class Press implements java.io.Serializable {

	// Fields

	private String name;
	private String phone;
	private String postcode;
	private String location;
	private Set bookses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Press() {
	}

	/** minimal constructor */
	public Press(String name) {
		this.name = name;
	}

	/** full constructor */
	public Press(String name, String phone, String postcode, String location, Set bookses) {
		this.name = name;
		this.phone = phone;
		this.postcode = postcode;
		this.location = location;
		this.bookses = bookses;
	}

	// Property accessors

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set getBookses() {
		return this.bookses;
	}

	public void setBookses(Set bookses) {
		this.bookses = bookses;
	}

}