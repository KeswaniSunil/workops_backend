package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the issuelink database table.
 * 
 */
@Entity
@NamedQuery(name="Issuelink.findAll", query="SELECT i FROM Issuelink i")
public class Issuelink implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private IssuelinkPK id;

	@Column(name="name")
	private String name;

	@Column(name="sequence")
	private int sequence;

	//bi-directional many-to-one association to Issue
//	@ManyToOne
//	@JoinColumn(name="parentIssue")
//	private Issue issue1;
//
//	//bi-directional many-to-one association to Issue
//	@ManyToOne
//	@JoinColumn(name="childIssue")
//	private Issue issue2;

	public Issuelink() {
	}

	public IssuelinkPK getId() {
		return this.id;
	}

	public void setId(IssuelinkPK id) {
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

//	public Issue getIssue1() {
//		return this.issue1;
//	}
//
//	public void setIssue1(Issue issue1) {
//		this.issue1 = issue1;
//	}
//
//	public Issue getIssue2() {
//		return this.issue2;
//	}
//
//	public void setIssue2(Issue issue2) {
//		this.issue2 = issue2;
//	}

}