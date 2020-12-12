package com.workops.pojo;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import com.workops.model.Project;

public class SprintData {
	
	private String id;
	private String name;
	private Calendar startdate;
	private Calendar enddate;
	private String goal;
	private int sequence;
	private int completed;
	private Project projectid;
	public SprintData(String id, String name, Calendar startdate, Calendar enddate, String goal, int sequence, int completed,
			Project projectid) {
		super();
		this.id = id;
		this.name = name;
		this.startdate = startdate;
		this.enddate = enddate;
		this.goal = goal;
		this.sequence = sequence;
		this.completed = completed;
		this.projectid = projectid;
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
	public Calendar getStartdate() {
		return startdate;
	}
	public void setStartdate(Calendar startdate) {
		this.startdate = startdate;
	}
	public Calendar getEnddate() {
		return enddate;
	}
	public void setEnddate(Calendar enddate) {
		this.enddate = enddate;
	}
	public String getGoal() {
		return goal;
	}
	public void setGoal(String goal) {
		this.goal = goal;
	}
	public int getSequence() {
		return sequence;
	}
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	public int getCompleted() {
		return completed;
	}
	public void setCompleted(int completed) {
		this.completed = completed;
	}
	public Project getProjectid() {
		return projectid;
	}
	public void setProjectid(Project projectid) {
		this.projectid = projectid;
	}
	
	
	
}
