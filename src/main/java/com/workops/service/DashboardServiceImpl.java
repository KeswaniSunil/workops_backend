package com.workops.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.workops.pojo.DashboardData;

@Service
@Transactional
public class DashboardServiceImpl implements DashboardService{

	@Override
	public DashboardData getDashboardData(String pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
