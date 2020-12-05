package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the issuetype database table.
 * 
 */
@Entity
@Table(name="issuetype")
@NamedQuery(name="Issuetype.findAll", query="SELECT i FROM Issuetype i")
public class Issuetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	@Column(name="name")
	private String name;

	@Column(name="sequence")
	private int sequence;

//	//bi-directional many-to-one association to Issue
//	@OneToMany(mappedBy="issuetypeBean")
//	private List<Issue> issues;

	//bi-directional many-to-one association to Avatar
	@ManyToOne
	@JoinColumn(name="avatarid")
	private Avatar avatar;

	public Issuetype() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSequence() {
		return this.sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

//	public List<Issue> getIssues() {
//		return this.issues;
//	}
//
//	public void setIssues(List<Issue> issues) {
//		this.issues = issues;
//	}
//
//	public Issue addIssue(Issue issue) {
//		getIssues().add(issue);
//		issue.setIssuetypeBean(this);
//
//		return issue;
//	}
//
//	public Issue removeIssue(Issue issue) {
//		getIssues().remove(issue);
//		issue.setIssuetypeBean(null);
//
//		return issue;
//	}

	public Avatar getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

}