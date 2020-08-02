package com.wata.payslip.model.dto;

import java.sql.Date;

import com.wata.payslip.model.entity.EmployeeEntity;

public class EmployeeDTO {
	public Integer id;
	public String fullName;
	public String telephone;
	public String email;
	public Date birthday;
	public Date joinDay;
	
	public EmployeeEntity toEntity() {
		return new EmployeeEntity(id, fullName, telephone, email, birthday, joinDay);
	}

}
