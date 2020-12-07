package com.workops.pojo;

import com.workops.model.Projectteam;

public class UserData {

	Projectteam projectteam;
	String fullName;
	public Projectteam getProjectteam() {
		return projectteam;
	}
	public void setProjectteam(Projectteam projectteam) {
		this.projectteam = projectteam;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
}

