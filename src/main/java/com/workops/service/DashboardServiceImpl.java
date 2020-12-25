package com.workops.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.dao.ComponentDao;
import com.workops.dao.IssueDao;
import com.workops.dao.ProjectteamDao;
import com.workops.dao.SprintDao;
import com.workops.dao.VersionDao;
import com.workops.pojo.DashboardData;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService{

	@Autowired
	ComponentDao componentDao;
	
	@Autowired
	VersionDao versionDao;
	
	@Autowired
	SprintDao sprintDao;
	
	@Autowired
	ProjectteamDao projectteamDao;
	
	@Autowired
	IssueDao issueDao; 
	
	@Override
	public DashboardData getDashboardData(String pid) {
		// TODO Auto-generated method stub
		DashboardData dd=new DashboardData();
		dd.setComponents(componentDao.countByProjectId(pid));
		dd.setVersions(versionDao.countByProjectId(pid));
		dd.setSprints(sprintDao.countByProjectId(pid));
		dd.setTeamsize(projectteamDao.countByProjectId(pid));
		dd.setIssues(issueDao.countByBacklog(pid));
		dd.setSprintIssues(issueDao.countBySprint(pid));
		return dd;
	}

}
