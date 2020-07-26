package com.wata.payslip.model;

import java.sql.Date;

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
