package com.wata.payslip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wata.payslip.model.dto.EmployeeDTO;
import com.wata.payslip.model.entity.EmployeeEntity;
import com.wata.payslip.repository.IEmployeeRepository;
import com.wata.payslip.service.EmployeeService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService = new EmployeeService(); 

	@GetMapping("/employee")
    public List<EmployeeEntity> getAllEmployee() {
		return employeeService.getAllEmployee();
    }
	
	@RequestMapping(value = "/employee", headers = "Accept=application/json", method = RequestMethod.POST)
    public EmployeeEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {	
		return employeeService.createEmployee(employeeDTO);
    }
	
	@GetMapping("/employee/{id}")
    public Optional <EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Integer id) {
		return employeeService.getEmployeeById(id);
    }

	@DeleteMapping("/employee/{id}")
	public String deleteEmployeeById(@PathVariable(value = "id") Integer id) {
			return employeeService.deleteEmployeeById(id);
		}
	
	
	@PutMapping("/employee/{id}")
	public EmployeeEntity replaceEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
		return employeeService.replaceEmployee(employeeDTO, id);
	  }
}
