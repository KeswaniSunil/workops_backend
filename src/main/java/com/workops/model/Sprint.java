package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the sprint database table.
 * 
 */
@Entity
@Table(name="sprint")
@NamedQuery(name="Sprint.findAll", query="SELECT s FROM Sprint s")
public class Sprint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	@Column(name="completed")
	private int completed;

	@Column(name="enddate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar enddate;

	@Column(name="goal")
	private String goal;

	@Column(name="name")
	private String name;

	@Column(name="sequence")
	private int sequence;

	@Column(name="startdate")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar startdate;

	//bi-directional many-to-one association to Project
	@ManyToOne
	@JoinColumn(name="projectid")
	private Project project;

	//bi-directional many-to-many association to Issue
//	@ManyToMany(mappedBy="sprints")
//	private List<Issue> issues;

	public Sprint() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getCompleted() {
		return this.completed;
	}

	public void setCompleted(int completed) {
		this.completed = completed;
	}

	public Calendar getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}

	public String getGoal() {
		return this.goal;
	}

	public void setGoal(String goal) {
		this.goal = goal;
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

	public Calendar getStartdate() {
		return this.startdate;
	}

	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}

	public Project getProject() {
		return this.project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

//	public List<Issue> getIssues() {
//		return this.issues;
//	}
//
//	public void setIssues(List<Issue> issues) {
//		this.issues = issues;
//	}

}