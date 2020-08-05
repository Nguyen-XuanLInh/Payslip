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

import com.wata.payslip.model.dto.EmployeeDTO;
import com.wata.payslip.model.dto.TypeProjectDTO;
import com.wata.payslip.model.entity.EmployeeEntity;
import com.wata.payslip.model.entity.TypeProjectEntity;
import com.wata.payslip.service.TypeProjectService;

@RestController
@RequestMapping("/api")
public class TypeProjectController {

	@Autowired
	private TypeProjectService typeProjectService = new TypeProjectService();

	@GetMapping("/type")
	public List<TypeProjectEntity> getAllTypeProject() {
		return typeProjectService.getAllTypeProject();
	}
	
	@PostMapping("/type")
	public TypeProjectEntity createTypeProject(@RequestBody TypeProjectDTO typeProjectDTO) {
		return typeProjectService.createTypeProject(typeProjectDTO);
	}
	
	@DeleteMapping("/type/{id}")
	public String deleteTypeProjectById(@PathVariable(value = "id") Integer id) {
		return typeProjectService.deleteTypeProjectById(id);
	}
	

	@PutMapping("/type/{id}")
	public TypeProjectEntity replaceTypeProject(@RequestBody TypeProjectDTO typeProjectDTO, @PathVariable Integer id) {
		return typeProjectService.replaceTypeProject(typeProjectDTO, id);
	}
	
}
