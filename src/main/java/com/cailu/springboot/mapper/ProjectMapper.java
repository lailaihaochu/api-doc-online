package com.cailu.springboot.mapper;

import java.util.List;

import com.cailu.springboot.entity.Project;

public interface ProjectMapper {
	
	public List<Project> getProjectList();
	
	public Project getProjectById(int id);
	
	public void insert(Project project);
	
	public void update(Project project);
	
	public void delete(int id);

}
