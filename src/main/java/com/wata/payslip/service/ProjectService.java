package com.wata.payslip.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wata.payslip.model.dto.ProjectDTO;
import com.wata.payslip.model.entity.ProjectEntity;
import com.wata.payslip.repository.IProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private IProjectRepository projectRepository;

	// Get All Project
	public List<ProjectEntity> getAllProject() {
		return projectRepository.findAll();
	}

	// Post New Project
	public ProjectEntity createProject(ProjectDTO project) {
		return projectRepository.save(project.toEntity());
	}
	
	//Put Project
	public ProjectEntity replaceProject(ProjectDTO projectDTO, Integer id) {

		ProjectEntity project = projectRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id + ""));
		if (projectDTO.nameProject != null) {
			project.setNameProject(projectDTO.nameProject);
		}
		
		if (projectDTO.startDate != null) {
			project.setStartDate(projectDTO.startDate);
		}
		
		if (projectDTO.endDate!= null) {
			project.setEndDate(projectDTO.endDate);
		}
		
		if (projectDTO.description != null) {
			project.setDescription(projectDTO.description);
		}
		return projectRepository.save(project);
	}
	
	public String deleteProjectById(Integer id) {
		projectRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		projectRepository.deleteById(id);
		return "ok";
	}
}
