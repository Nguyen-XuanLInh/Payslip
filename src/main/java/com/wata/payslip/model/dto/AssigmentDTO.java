package com.wata.payslip.model.dto;

import com.wata.payslip.model.entity.AssigmentEntity;
import com.wata.payslip.model.entity.EmployeeEntity;
import com.wata.payslip.model.entity.ProjectEntity;

public class AssigmentDTO {
	public Integer id;
	public EmployeeEntity employeeEntity;
	public ProjectEntity projectEntity;
	
	public AssigmentEntity toEntity() {
		
		return new AssigmentEntity(id, projectEntity, employeeEntity);
	}
}
