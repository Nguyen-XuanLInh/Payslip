package com.wata.payslip.model.dto;

import java.util.Date;

import com.wata.payslip.model.entity.ProjectEntity;
import com.wata.payslip.model.entity.TypeProjectEntity;

public class ProjectDTO {
	
	public Integer id;
	public String nameProject;
	public Date startDate;
	public Date endDate;
	public String description;
//	public List<TaskEntity> task;
	public TypeProjectEntity typeProjectEntity;
	
	public ProjectEntity toEntity() {
		return new ProjectEntity(id, typeProjectEntity, description, endDate, endDate, description);
	}
}
