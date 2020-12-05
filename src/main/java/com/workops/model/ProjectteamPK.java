package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the projectteam database table.
 * 
 */
@Embeddable
public class ProjectteamPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false,nullable=false)
	private String email;

	@Column(name="projectid",insertable=false, updatable=false,nullable=false)
	private String projectId;

	public ProjectteamPK() {
	}
	public ProjectteamPK(String email, String projectId) {
		super();
		this.email = email;
		this.projectId = projectId;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
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
			this.email.equals(castOther.email)
			&& this.projectId.equals(castOther.projectId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.email.hashCode();
		hash = hash * prime + this.projectId.hashCode();
		
		return hash;
	}
}