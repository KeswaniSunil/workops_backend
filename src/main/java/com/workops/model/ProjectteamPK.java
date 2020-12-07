package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the projectteam database table.
 * 
 */
@Embeddable
public class ProjectteamPK implements Serializable {
	public Userprofile getUser() {
		return user;
	}
	public void setUser(Userprofile user) {
		this.user = user;
	}

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

//	@Column(insertable=false, updatable=false,nullable=false)
	@ManyToOne
	@JoinColumn(name="email")
	private Userprofile user;

	@Column(name="projectid",insertable=false, updatable=false,nullable=false)
	private String projectId;

	public ProjectteamPK() {
	}
	public ProjectteamPK(Userprofile user, String projectId) {
		super();
		this.user=user;
		this.projectId = projectId;
	}
	
	public String getProjectId() {
		return this.projectId;
	}
	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectteamPK)) {
			return false;
		}
		ProjectteamPK castOther = (ProjectteamPK)other;
		return 
			this.user.equals(castOther.user)
			&& this.projectId.equals(castOther.projectId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.user.hashCode();
		hash = hash * prime + this.projectId.hashCode();
		
		return hash;
	}
}