package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="issueversion")

//@NamedQuery(name="Issueversion.findAll", query="SELECT i FROM issueversion i")
public class Issueversion implements Serializable {
	
	public Issueversion(IssueversionPK id) {
		super();
		this.id = id;
	}
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private IssueversionPK id;
	public IssueversionPK getId() {
		return id;
	}
	public void setId(IssueversionPK id) {
		this.id = id;
	}
	public Issueversion() {}

}