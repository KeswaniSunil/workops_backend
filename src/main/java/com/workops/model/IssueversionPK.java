package com.workops.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class IssueversionPK implements Serializable{

		@ManyToOne
		@JoinColumn(name="issueid")
		private Issue issue;
		public IssueversionPK(Issue issue,String versionId) {
			super();
			this.versionId = versionId;
			this.issue=issue;
		}

		@Column(name="versionid",insertable=false, updatable=false,nullable=false)
//		@ManyToOne
//		@JoinColumn(name="componentid")
		private String versionId;
		
		public IssueversionPK() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		public Issue getIssue() {
			return issue;
		}
		public void setIssue(Issue issue) {
			this.issue = issue;
		}
		public String getVersionId() {
			return versionId;
		}

		public void setVersionId(String versionId) {
			this.versionId = versionId;
		}
		
		public boolean equals(Object other) {
			if (this == other) {
				return true;
			}
			if (!(other instanceof IssueversionPK)) {
				return false;
			}
			IssueversionPK castOther = (IssueversionPK)other;
			return 
				this.issue.equals(castOther.issue)
				&& this.versionId.equals(castOther.versionId);
		}
		public int hashCode() {
			final int prime = 31;
			int hash = 17;
			hash = hash * prime + this.issue.hashCode();
			hash = hash * prime + this.versionId.hashCode();
			
			return hash;
		}
		
}
