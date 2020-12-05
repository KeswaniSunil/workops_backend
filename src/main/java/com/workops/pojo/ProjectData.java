package com.workops.pojo;

import com.workops.model.Project;
import com.workops.model.Projectteam;

public class ProjectData {

	private String id;
	private String name;
	private String projectKey;
	private String desciption;
	private int selected;
	private String email;
	public ProjectData(String id, String name, String projectKey, String desciption, int selected, String email) {
		super();
		this.id = id;
		this.name = name;
		this.projectKey = projectKey;
		this.desciption = desciption;
		this.selected = selected;
		this.email = email;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProjectKey() {
		return projectKey;
	}
	public void setProjectKey(String projectKey) {
		this.projectKey = projectKey;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public int getSelected() {
		return selected;
	}
	public void setSelected(int selected) {
		this.selected = selected;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
