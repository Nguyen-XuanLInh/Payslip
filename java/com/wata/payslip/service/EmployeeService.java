package com.wata.payslip.service;

import static java.lang.Integer.parseInt;

import java.sql.Date;
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
import com.wata.payslip.model.dto.PaginationList;
import com.wata.payslip.model.dto.searchString;
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
	
	public List<EmployeeEntity> createSearchEmployee(EmployeeDTO employee) {
		ArrayList<EmployeeEntity> result = new ArrayList<EmployeeEntity>();
		ArrayList<EmployeeEntity> data = (ArrayList<EmployeeEntity>) employeeRepository.findAll();
		ArrayList<EmployeeEntity> tmp = new ArrayList<EmployeeEntity>();
		
		if (employee.id != null) {
			result.clear();
			for (EmployeeEntity employeeEntity : data) {
				if (employeeEntity.getId() == employee.id) {
					result.add(employeeEntity);
					return result;
				}
			}
		}
		
		if (employee.email != null) {
			result.clear();
			for (EmployeeEntity employeeEntity : data) {
				if (employeeEntity.getEmail() == employee.email) {
					result.add(employeeEntity);
					return result;
				}
			}
		}
		
		if (employee.fullName == null) {
			employee.fullName = "";
		}
		
		if (employee.telephone == null) {
			employee.telephone = "";
		}
		
		if (employee.birthday == null) {
			employee.birthday = new Date(0);
		}
		
		if (employee.joinDay == null) {
			employee.joinDay = new Date(0);
		}
		
//		for (EmployeeEntity employeeEntity : data) {
//			if (employeeEntity.getFullName().toLowerCase().contains(employee.))
//		}
		
		return result;
	}
	
	public PaginationList<EmployeeEntity> getEmployees(String searchString, String pageSize, String currentPage) {
		
		int pagesize = Integer.parseInt(pageSize);
		int currentpage = Integer.parseInt(currentPage);
		
		ArrayList<EmployeeEntity> result = new ArrayList<EmployeeEntity>();
		result =  (ArrayList<EmployeeEntity>) employeeRepository.findAll();
		
		if(searchString != "") {
			EmployeeSpecification spec = new EmployeeSpecification(new SearchCriteria("fullName", ":", searchString));
			result = (ArrayList<EmployeeEntity>) employeeRepository.findAll(spec);
		}
		Integer total = result.size();
		Integer totalPage = total/pagesize;
		Integer totalItem = result.size();
		result = (ArrayList<EmployeeEntity>) result.subList((currentpage - 1) * pagesize, (currentpage - 1) * pagesize + pagesize);
		PaginationList<EmployeeEntity> pagiantionlist = new PaginationList<EmployeeEntity>(result, currentpage, totalPage, pagesize, totalItem);
		
		
		return pagiantionlist;
	}

	
}
