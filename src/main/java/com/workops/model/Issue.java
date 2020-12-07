package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the issue database table.
 * 
 */
@Entity
@NamedQuery(name="Issue.findAll", query="SELECT i FROM Issue i")
public class Issue implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	@Column(name="createdon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdOn;

	@Column(name="description")
	private String description;

	@Column(name="duedate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date duedate;

	@Column(name="name")
	private String name;

	@Column(name="updatedon")
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedOn;

	//bi-directional many-to-many association to Component
//	@ManyToMany(mappedBy="issues")
//	private List<Component> components;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="assignedto")
	private User user1;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="createdby")
	private User user2;

	//bi-directional many-to-one association to Issuepriority
	@ManyToOne
	@JoinColumn(name="issuepriority")
	private Issuepriority issuepriorityBean;

	//bi-directional many-to-one association to Issuestatus
	@ManyToOne
	@JoinColumn(name="issuestatus")
	private Issuestatus issuestatus;

	//bi-directional many-to-one association to Issuetype
	@ManyToOne
	@JoinColumn(name="issuetype")
	private Issuetype issuetypeBean;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="reportedby")
	private User user3;

	//bi-directional many-to-one association to Issueattachment
//	@OneToMany(mappedBy="issue")
//	private List<Issueattachment> issueattachments;

	//bi-directional many-to-one association to Issuelink
//	@OneToMany(mappedBy="issue1")
//	private List<Issuelink> issuelinks1;

	//bi-directional many-to-one association to Issuelink
//	@OneToMany(mappedBy="issue2")
//	private List<Issuelink> issuelinks2;

	//bi-directional many-to-many association to Version
//	@ManyToMany(mappedBy="issues")
//	private List<Version> versions;

//	//bi-directional many-to-many association to Sprint
//	@ManyToMany
//	@JoinTable(
//		name="sprintissue"
//		, joinColumns={
//			@JoinColumn(name="issueId")
//			}
//		, inverseJoinColumns={
//			@JoinColumn(name="sprintId")
//			}
//		)
//	private List<Sprint> sprints;

	public Issue() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return this.createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getDuedate() {
		return this.duedate;
	}

	public void setDuedate(Date duedate) {
		this.duedate = duedate;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getUpdatedOn() {
		return this.updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

//	public List<Component> getComponents() {
//		return this.components;
//	}
//
//	public void setComponents(List<Component> components) {
//		this.components = components;
//	}

	public User getUser1() {
		return this.user1;
	}

	public void setUser1(User user1) {
		this.user1 = user1;
	}

	public User getUser2() {
		return this.user2;
	}

	public void setUser2(User user2) {
		this.user2 = user2;
	}

	public Issuepriority getIssuepriorityBean() {
		return this.issuepriorityBean;
	}

	public void setIssuepriorityBean(Issuepriority issuepriorityBean) {
		this.issuepriorityBean = issuepriorityBean;
	}

	public Issuestatus getIssuestatus() {
		return this.issuestatus;
	}

	public void setIssuestatus(Issuestatus issuestatus) {
		this.issuestatus = issuestatus;
	}

	public Issuetype getIssuetypeBean() {
		return this.issuetypeBean;
	}

	public void setIssuetypeBean(Issuetype issuetypeBean) {
		this.issuetypeBean = issuetypeBean;
	}

	public User getUser3() {
		return this.user3;
	}

	public void setUser3(User user3) {
		this.user3 = user3;
	}

//	public List<Issueattachment> getIssueattachments() {
//		return this.issueattachments;
//	}
//
//	public void setIssueattachments(List<Issueattachment> issueattachments) {
//		this.issueattachments = issueattachments;
//	}
//
//	public Issueattachment addIssueattachment(Issueattachment issueattachment) {
//		getIssueattachments().add(issueattachment);
//		issueattachment.setIssue(this);
//
//		return issueattachment;
//	}
//
//	public Issueattachment removeIssueattachment(Issueattachment issueattachment) {
//		getIssueattachments().remove(issueattachment);
//		issueattachment.setIssue(null);
//
//		return issueattachment;
//	}
//
//	public List<Issuelink> getIssuelinks1() {
//		return this.issuelinks1;
//	}
//
//	public void setIssuelinks1(List<Issuelink> issuelinks1) {
//		this.issuelinks1 = issuelinks1;
//	}
//
//	public Issuelink addIssuelinks1(Issuelink issuelinks1) {
//		getIssuelinks1().add(issuelinks1);
//		issuelinks1.setIssue1(this);
//
//		return issuelinks1;
//	}
//
//	public Issuelink removeIssuelinks1(Issuelink issuelinks1) {
//		getIssuelinks1().remove(issuelinks1);
//		issuelinks1.setIssue1(null);
//
//		return issuelinks1;
//	}
//
//	public List<Issuelink> getIssuelinks2() {
//		return this.issuelinks2;
//	}
//
//	public void setIssuelinks2(List<Issuelink> issuelinks2) {
//		this.issuelinks2 = issuelinks2;
//	}
//
//	public Issuelink addIssuelinks2(Issuelink issuelinks2) {
//		getIssuelinks2().add(issuelinks2);
//		issuelinks2.setIssue2(this);
//
//		return issuelinks2;
//	}
//
//	public Issuelink removeIssuelinks2(Issuelink issuelinks2) {
//		getIssuelinks2().remove(issuelinks2);
//		issuelinks2.setIssue2(null);
//
//		return issuelinks2;
//	}
//
//	public List<Version> getVersions() {
//		return this.versions;
//	}
//
//	public void setVersions(List<Version> versions) {
//		this.versions = versions;
//	}
//
//	public List<Sprint> getSprints() {
//		return this.sprints;
//	}
//
//	public void setSprints(List<Sprint> sprints) {
//		this.sprints = sprints;
//	}

}