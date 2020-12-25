package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the projectteam database table.
 * 
 */
@Embeddable
public class ComponentissuePK implements Serializable {

	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	public Issue getIssue() {
		return issue;
	}




	public void setIssue(Issue issue) {
		this.issue = issue;
	}

	@ManyToOne
	@JoinColumn(name="issueid")
	private Issue issue;
	public ComponentissuePK(Issue issue,String componentId) {
		super();
		this.componentId = componentId;
		this.issue=issue;
	}

	@Column(name="componentid",insertable=false, updatable=false,nullable=false)
//	@ManyToOne
//	@JoinColumn(name="componentid")
	private String componentId;


	public ComponentissuePK() {
	}

	
	

	public String getComponentId() {
		return componentId;
	}




	public void setComponentId(String componentId) {
		this.componentId = componentId;
	}

	
	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProjectteamPK)) {
			return false;
		}
		ComponentissuePK castOther = (ComponentissuePK)other;
		return 
			this.issue.equals(castOther.issue)
			&& this.componentId.equals(castOther.componentId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.issue.hashCode();
		hash = hash * prime + this.componentId.hashCode();
		
		return hash;
	}
}