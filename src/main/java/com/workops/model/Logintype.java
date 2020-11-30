package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the logintype database table.
 * 
 */
@Entity
@Table(name="logintype")
public class Logintype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String type;


	public Logintype() {
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}



}