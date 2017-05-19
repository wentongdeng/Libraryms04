package com.it.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Smalltype entity. @author MyEclipse Persistence Tools
 */

public class Smalltype implements java.io.Serializable {

	// Fields

	private String typename;
	private Bigtype bigtype;
	private Set bookses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Smalltype() {
	}

	/** minimal constructor */
	public Smalltype(String typename, Bigtype bigtype) {
		this.typename = typename;
		this.bigtype = bigtype;
	}

	/** full constructor */
	public Smalltype(String typename, Bigtype bigtype, Set bookses) {
		this.typename = typename;
		this.bigtype = bigtype;
		this.bookses = bookses;
	}

	// Property accessors

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Bigtype getBigtype() {
		return this.bigtype;
	}

	public void setBigtype(Bigtype bigtype) {
		this.bigtype = bigtype;
	}

	public Set getBookses() {
		return this.bookses;
	}

	public void setBookses(Set bookses) {
		this.bookses = bookses;
	}

}