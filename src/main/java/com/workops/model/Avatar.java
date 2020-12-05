package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the avatar database table.
 * 
 */
@Entity
@NamedQuery(name="Avatar.findAll", query="SELECT a FROM Avatar a")
public class Avatar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	public Avatar() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Avatar(String id, String name, String url) {
		super();
		this.id = id;
		this.name = name;
		this.url = url;
	}

	@Column(name="name")
	private String name;

	@Column(name="url")
	private String url;
	
}