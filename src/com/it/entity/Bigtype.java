package com.it.entity;

import java.util.HashSet;
import java.util.Set;

/**
 * Bigtype entity. @author MyEclipse Persistence Tools
 */

public class Bigtype implements java.io.Serializable {

	// Fields

	private String typename;
	private Set smalltypes = new HashSet(0);

	// Constructors

	/** default constructor */
	public Bigtype() {
	}

	/** minimal constructor */
	public Bigtype(String typename) {
		this.typename = typename;
	}

	/** full constructor */
	public Bigtype(String typename, Set smalltypes) {
		this.typename = typename;
		this.smalltypes = smalltypes;
	}

	// Property accessors

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Set getSmalltypes() {
		return this.smalltypes;
	}

	public void setSmalltypes(Set smalltypes) {
		this.smalltypes = smalltypes;
	}

}