package com.wata.payslip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wata.payslip.model.dto.ProjectDTO;
import com.wata.payslip.model.entity.ProjectEntity;
import com.wata.payslip.service.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	@Autowired
	private ProjectService projectService = new ProjectService();

	@GetMapping("/project")
	public List<ProjectEntity> getAllProject() {
		return projectService.getAllProject();
	}
	
	@PostMapping("/project")
	public ProjectEntity createProject(@RequestBody ProjectDTO projectDTO) {
		return projectService.createProject(projectDTO);
	}
	
	@PutMapping("/project/{id}")
	public ProjectEntity replaceProject(@RequestBody ProjectDTO projectDTO, @PathVariable Integer id) {
		return projectService.replaceProject(projectDTO, id);
	}
	
	@DeleteMapping("/project/{id}")
	public String deleteProjectById(@PathVariable(value = "id") Integer id) {
		return projectService.deleteProjectById(id);
	}
	
}
