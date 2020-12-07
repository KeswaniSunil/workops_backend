package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the issueattachment database table.
 * 
 */
@Entity
@Table(name="issueattachment")
@NamedQuery(name="Issueattachment.findAll", query="SELECT i FROM Issueattachment i")
public class Issueattachment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="id")
	@Id
	private String id;

	@Column(name="author")
	private String author;

	@Column(name="fileurl")
	private String fileUrl;

	@Column(name="name")
	private String name;

	//bi-directional many-to-one association to Issue
	@ManyToOne
	@JoinColumn(name="issueid")
	private Issue issue;

	public Issueattachment() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getFileUrl() {
		return this.fileUrl;
	}

	public void setFileUrl(String fileUrl) {
		this.fileUrl = fileUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Issue getIssue() {
		return this.issue;
	}

	public void setIssue(Issue issue) {
		this.issue = issue;
	}

}



