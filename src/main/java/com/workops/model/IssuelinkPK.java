package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the issuelink database table.
 * 
 */
@Embeddable
public class IssuelinkPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="parentissue",insertable=false, updatable=false)
	private String parentIssue;

	@Column(name="childissue",insertable=false, updatable=false)
	private String childIssue;

	public IssuelinkPK() {
	}
	public String getParentIssue() {
		return this.parentIssue;
	}
	public void setParentIssue(String parentIssue) {
		this.parentIssue = parentIssue;
	}
	public String getChildIssue() {
		return this.childIssue;
	}
	public void setChildIssue(String childIssue) {
		this.childIssue = childIssue;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof IssuelinkPK)) {
			return false;
		}
		IssuelinkPK castOther = (IssuelinkPK)other;
		return 
			this.parentIssue.equals(castOther.parentIssue)
			&& this.childIssue.equals(castOther.childIssue);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.parentIssue.hashCode();
		hash = hash * prime + this.childIssue.hashCode();
		
		return hash;
	}
}