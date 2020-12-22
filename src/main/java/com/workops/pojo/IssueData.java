package com.workops.pojo;

public class IssueData {

 private String id;
 private String name;
 private String createdon;
 private String updatedon;
 private String duedate;
 private String description;
 private String issuetype;
 private String issuepriority;
 private String issuestatus;
 private String reportedby;
 private String assignedto;
 public IssueData() {
	super();
	// TODO Auto-generated constructor stub
}
private String createdby;
 private String projectid;
 private String sprintid;
public IssueData(String id, String name, String createdon, String updatedon, String duedate, String description,
		String issuetype, String issuepriority, String issuestatus, String reportedby, String assignedto,
		String createdby, String projectid, String sprintid) {
	super();
	this.id = id;
	this.name = name;
	this.createdon = createdon;
	this.updatedon = updatedon;
	this.duedate = duedate;
	this.description = description;
	this.issuetype = issuetype;
	this.issuepriority = issuepriority;
	this.issuestatus = issuestatus;
	this.reportedby = reportedby;
	this.assignedto = assignedto;
	this.createdby = createdby;
	this.projectid = projectid;
	this.sprintid = sprintid;
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
public String getCreatedon() {
	return createdon;
}
public void setCreatedon(String createdon) {
	this.createdon = createdon;
}
public String getUpdatedon() {
	return updatedon;
}
public void setUpdatedon(String updatedon) {
	this.updatedon = updatedon;
}
public String getDuedate() {
	return duedate;
}
public void setDuedate(String duedate) {
	this.duedate = duedate;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public String getIssuetype() {
	return issuetype;
}
public void setIssuetype(String issuetype) {
	this.issuetype = issuetype;
}
public String getIssuepriority() {
	return issuepriority;
}
public void setIssuepriority(String issuepriority) {
	this.issuepriority = issuepriority;
}
public String getIssuestatus() {
	return issuestatus;
}
public void setIssuestatus(String issuestatus) {
	this.issuestatus = issuestatus;
}
public String getReportedby() {
	return reportedby;
}
public void setReportedby(String reportedby) {
	this.reportedby = reportedby;
}
public String getAssignedto() {
	return assignedto;
}
public void setAssignedto(String assignedto) {
	this.assignedto = assignedto;
}
public String getCreatedby() {
	return createdby;
}
public void setCreatedby(String createdby) {
	this.createdby = createdby;
}
public String getProjectid() {
	return projectid;
}
public void setProjectid(String projectid) {
	this.projectid = projectid;
}
public String getSprintid() {
	return sprintid;
}
public void setSprintid(String sprintid) {
	this.sprintid = sprintid;
}
}
