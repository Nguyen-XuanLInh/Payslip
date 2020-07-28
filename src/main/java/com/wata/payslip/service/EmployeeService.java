package com.wata.payslip.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.wata.payslip.model.dto.EmployeeDTO;
import com.wata.payslip.model.entity.EmployeeEntity;
import com.wata.payslip.repository.IEmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	public List<EmployeeEntity> getAllEmployee() {
		return employeeRepository.findAll();
	}
	
	public EmployeeEntity createEmployee(EmployeeDTO employee) {
		return employeeRepository.save(employee.toEntity());
	}

	 public Optional <EmployeeEntity> getEmployeeById(Integer id) {
		 employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		 return employeeRepository.findById(id);
	 }
	 
	 public String deleteEmployeeById(Integer id) {
         employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
         employeeRepository.deleteById(id);   
         return "ok";
	 } 
	 
	public EmployeeEntity replaceEmployee(EmployeeDTO employeeDTO,Integer id) {
		
		EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		if (employeeDTO.birthday != null) {
			employee.setBirthday(employeeDTO.birthday);
		}

		if (employeeDTO.email != null) {
			employee.setEmail(employeeDTO.email);
		}
		
		if (employeeDTO.fullName != null) {
			employee.setFullName(employeeDTO.fullName);
		}
		
		if (employeeDTO.telephone != null) {
			employee.setTelephone(employeeDTO.telephone);
		}
		
		if (employeeDTO.joinDay != null) {
			employee.setJoinDay(employeeDTO.joinDay);
		}

		return employeeRepository.save(employee);
	}	 
	 
	public List<EmployeeEntity> getEmployeeByName(String fullName ) {
//		List<EmployeeEntity> data = employeeRepository.findAll();
		ArrayList<EmployeeEntity> result = new ArrayList<EmployeeEntity>();
//		for (EmployeeEntity employeeEntity : data) {
//			if (employeeEntity.getFullName().toLowerCase().trim().contains(fullName.toLowerCase().trim())) {
//				result.add(employeeEntity);
//			}
//		}
		
		EmployeeSpecification spec = new EmployeeSpecification(new SearchCriteria("fullName", ":", fullName));
		result = (ArrayList<EmployeeEntity>) employeeRepository.findAll(spec);
		return result;
	}
	
}
