package com.wata.payslip.model.dto;

import java.util.List;

import com.wata.payslip.model.entity.ProjectEntity;
import com.wata.payslip.model.entity.TypeProjectEntity;

public class TypeProjectDTO {
	public Integer id;
	public String typeName;
	public List<ProjectEntity> project;

	public TypeProjectEntity toEntity() {

		return new TypeProjectEntity(id, typeName, project);
	}
}
