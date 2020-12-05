package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.Type;

import java.util.List;


/**
 * The persistent class for the logintype database table.
 * 
 */
@Entity
@Table(name="project")
public class Project implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	private String id;

	private String description;

	private String name;

	private String projectkey;
	
	private int selected;

	public int getSelected() {
		return selected;
	}

	public void setSelected(int selected) {
		this.selected = selected;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProjectkey() {
		return projectkey;
	}

	public void setProjectkey(String projectkey) {
		this.projectkey = projectkey;
	}



}