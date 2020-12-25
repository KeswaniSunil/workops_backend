package com.workops.pojo;

public class DashboardData {

	private int issues,sprints,sprintIssues,components,versions,teamsize;
	public DashboardData() {
		// TODO Auto-generated constructor stub
	}
	public int getIssues() {
		return issues;
	}
	public int getSprintIssues() {
		return sprintIssues;
	}
	public void setSprintIssues(int sprintIssues) {
		this.sprintIssues = sprintIssues;
	}
	public void setIssues(int issues) {
		this.issues = issues;
	}
	public int getSprints() {
		return sprints;
	}
	public void setSprints(int sprints) {
		this.sprints = sprints;
	}
	public int getComponents() {
		return components;
	}
	public void setComponents(int components) {
		this.components = components;
	}
	public int getVersions() {
		return versions;
	}
	public void setVersions(int versions) {
		this.versions = versions;
	}
	public int getTeamsize() {
		return teamsize;
	}
	public void setTeamsize(int teamsize) {
		this.teamsize = teamsize;
	}
	
}
