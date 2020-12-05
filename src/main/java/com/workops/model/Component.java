package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the component database table.
 * 
 */
@Entity
@Table(name="component")
public class Component implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;

	//bi-directional many-to-many association to Issue
//	@ManyToMany
//	@JoinTable(
//		name="componentissue"
//		, joinColumns={
//			@JoinColumn(name="componentId")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="issueId")
//			}
//		)
//	private List<Issue> issues;

	public Component() {
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