package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the avatar database table.
 * 
 */
@Entity
@Table(name="componentissue")

@NamedQuery(name="Componentissue.findAll", query="SELECT i FROM Componentissue i")
public class Componentissue implements Serializable {
	public Componentissue(ComponentissuePK id) {
		super();
		this.id = id;
	}
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private ComponentissuePK id;
	public ComponentissuePK getId() {
		return id;
	}
	public void setId(ComponentissuePK id) {
		this.id = id;
	}
	public Componentissue() {}
}