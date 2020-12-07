package com.workops.pojo;

import com.workops.model.Project;
import com.workops.model.Projectteam;

public class ProjectData {

	private String id;
	private String name;
	private String projectKey;
	private String description;
	private String email;
	public ProjectData(String id, String name, String projectKey, String description, int selected, String email) {
		super();
		this.id = id;
		this.name = name;
		this.projectKey = projectKey;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
