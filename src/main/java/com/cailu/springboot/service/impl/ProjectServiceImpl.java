package com.cailu.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cailu.springboot.entity.Project;
import com.cailu.springboot.mapper.IProjectMapper;
import com.cailu.springboot.service.IProjectService;
@Service
public class ProjectServiceImpl implements IProjectService{
	
	@Autowired
	public IProjectMapper projectMapper;

	@Override
	public List<Project> getProjectList() {
		// TODO Auto-generated method stub
		return projectMapper.getProjectList();
	}

	@Override
	public Project getProjectById(int id) {
		// TODO Auto-generated method stub
		return projectMapper.getProjectById(id);
	}

	@Override
	public void insert(Project project) {
		projectMapper.insert(project);
		
	}

	@Override
	public void update(Project project) {
		projectMapper.update(project);
		
	}

	@Override
	public void delete(int id) {
		projectMapper.delete(id);
	}

}
