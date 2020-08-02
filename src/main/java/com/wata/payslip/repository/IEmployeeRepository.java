package com.wata.payslip.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.wata.payslip.model.entity.EmployeeEntity;

@Repository
public interface IEmployeeRepository extends JpaRepository<EmployeeEntity, Integer>, JpaSpecificationExecutor<EmployeeEntity>{
	Page<EmployeeEntity> findByFullNameContaining(String fullName, Pageable pageable);
	
	@Query("FROM EmployeeEntity")
	ArrayList<EmployeeEntity> findAll();
	
	@Query("FROM EmployeeEntity WHERE fullName LIKE %?1")
	ArrayList<EmployeeEntity> findByName(String fullName);
	
//	Page<EmployeeEntity> findAlla(Specification<T> spec, Pageable pageable);
//	myRepository.findAll(textInAllColumns(searchText), pageable);
}

