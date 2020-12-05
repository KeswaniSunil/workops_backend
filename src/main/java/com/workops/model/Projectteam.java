package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the projectteam database table.
 * 
 */
@Entity
@Table(name="projectteam")

public class Projectteam implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProjectteamPK id;

	//bi-directional many-to-one association to Project
//	@ManyToOne
//	@JoinColumn(name="projectid",insertable=false,updatable=false)
//	private Project project;
//
//	//bi-directional many-to-one association to User
//	@ManyToOne
//	@JoinColumn(name="email",insertable=false,updatable=false)
//	private User user;

	//bi-directional many-to-one association to Role
	@ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

	public Projectteam() {
	}

	public ProjectteamPK getId() {
		return this.id;
	}

	public void setId(ProjectteamPK id) {
		this.id = id;
	}
//
//	public Project getProject() {
//		return this.project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}
//
//	public User getUser() {
//		return this.user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

}