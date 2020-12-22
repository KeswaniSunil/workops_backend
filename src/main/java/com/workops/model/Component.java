package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;


/**
 * The persistent class for the component database table.
 * 
 */
@Entity
@Table(name="component")
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	@Column(name="description")
	private String description;

	@Column(name="name")
	private String name;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;

	@ManyToOne
	@JoinColumn(name="email")
	private Userprofile user; 
//	//bi-directional many-to-many association to Issue
//	@ManyToMany(mappedBy="components")
////	@JoinTable(
////		name="componentissue"
////		, joinColumns={
////			@JoinColumn(name="componentid")
////			}
////		, inverseJoinColumns={
////			@JoinColumn(name="issueid")
////			}
////		)
//	@JsonIgnore
//	private List<Issue> issues;



	public Component() {
	}

	public Userprofile getUser() {
		return user;
	}

	public void setUser(Userprofile user) {
		this.user = user;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
//
//	public List<Issue> getIssues() {
//		return this.issues;
//	}
//
//	public void setIssues(List<Issue> issues) {
//		this.issues = issues;
//	}

}