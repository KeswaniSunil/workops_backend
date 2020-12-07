package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the version database table.
 * 
 */
@Entity
@Table(name="version")
@NamedQuery(name="Version.findAll", query="SELECT v FROM Version v")
public class Version implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	@Column(name="description")
	private String description;

	@Column(name="name")
	private String name;

	@Column(name="releasedate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date releasedate;

	//bi-directional many-to-many association to Issue
//	@ManyToMany
//	@JoinTable(
//		name="issueversion"
//		, joinColumns={
//			@JoinColumn(name="versionId")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="issueId")
//			}
//		)
//	private List<Issue> issues;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;

	public Version() {
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

	public Date getReleasedate() {
		return this.releasedate;
	}

	public void setReleasedate(Date releasedate) {
		this.releasedate = releasedate;
	}

//	public List<Issue> getIssues() {
//		return this.issues;
//	}
//
//	public void setIssues(List<Issue> issues) {
//		this.issues = issues;
//	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

}