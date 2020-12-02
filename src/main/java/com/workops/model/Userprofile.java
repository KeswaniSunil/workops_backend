package com.workops.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userprofile database table.
 * 
 */
@Entity
@Table(name="userprofile")
@NamedQuery(name="Userprofile.findAll", query="SELECT u FROM Userprofile u")
public class Userprofile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="email")
	@Id
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getOrganisation() {
		return organisation;
	}

	public void setOrganisation(String organisation) {
		this.organisation = organisation;
	}

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	public String getUserlocaltime() {
		return userlocaltime;
	}

	public void setUserlocaltime(String userlocaltime) {
		this.userlocaltime = userlocaltime;
	}




	@Column(name="department")
	private String department;

	@Column(name="fullname")
	private String fullName;

	@Column(name="mobileno")
	private String mobileNo;

	@Column(name="organisation")
	private String organisation;

	@Column(name="publicname")
	private String publicName;

	@Column(name="userlocaltime")
	private String userlocaltime;

	@Column(name="selectedproject")
	private String selectedProject;


	public String getSelectedProject() {
		return selectedProject;
	}

	public void setSelectedProject(String selectedProject) {
		this.selectedProject = selectedProject;
	}
	@OneToOne
	@JoinColumn(name="email")
	private User user;

	public Userprofile() {
	}



}