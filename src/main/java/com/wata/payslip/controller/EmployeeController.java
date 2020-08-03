package com.wata.payslip.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wata.payslip.model.dto.EmployeeDTO;
import com.wata.payslip.model.dto.SearchData;
import com.wata.payslip.model.entity.EmployeeEntity;
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

	@PostMapping("/employee")
	public EmployeeEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {
		return employeeService.createEmployee(employeeDTO);
	}

	@GetMapping("/employee/{id}")
	public Optional<EmployeeEntity> getEmployeeById(@PathVariable(value = "id") Integer id) {
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

	@PostMapping("/employee/pages")
	public ResponseEntity<Map<String, Object>> searchEmployeeByFullName(@RequestBody SearchData searchData) {
		// default currentPage = 0, pageSize = 3
		return employeeService.searchEmployeeByFullName(searchData);
	}
}
