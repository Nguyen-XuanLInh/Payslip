package com.wata.payslip.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.wata.payslip.model.entity.EmployeeEntity;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, JpaSpecificationExecutor<EmployeeEntity>{
	
}
