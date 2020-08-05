package com.wata.payslip.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wata.payslip.model.dto.TypeProjectDTO;
import com.wata.payslip.model.entity.TypeProjectEntity;
import com.wata.payslip.repository.ITypeProjectRepositoty;

@Service
public class TypeProjectService {

	@Autowired
	private ITypeProjectRepositoty typeProjectRepositoty;

	// Get All
	public List<TypeProjectEntity> getAllTypeProject() {
		return typeProjectRepositoty.findAll();
	}

	public TypeProjectEntity createTypeProject(TypeProjectDTO typeProject) {
		return typeProjectRepositoty.save(typeProject.toEntity());
	}

	public String deleteTypeProjectById(Integer id) {

		typeProjectRepositoty.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		typeProjectRepositoty.deleteById(id);
		return "ok";
	}

	public TypeProjectEntity replaceTypeProject(TypeProjectDTO typeProjectDTO, Integer id ) {
		TypeProjectEntity typeProject = typeProjectRepositoty.findById(id)
		.orElseThrow(() -> new EntityNotFoundException(id + ""));
		if (typeProjectDTO.typeName != null) {
			typeProject.setTypeName(typeProjectDTO.typeName);
		}
		return typeProjectRepositoty.save(typeProject);
	}
	
}
