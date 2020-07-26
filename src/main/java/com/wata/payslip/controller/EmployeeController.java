package com.wata.payslip.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wata.payslip.model.EmployeeDTO;
import com.wata.payslip.model.EmployeeEntity;
import com.wata.payslip.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
    private EmployeeRepository employeeRepository;

	@GetMapping("/employee")
    public List<EmployeeEntity> getAllEmployee() {
        return employeeRepository.findAll();
    }
	
	@RequestMapping(value = "/employee", headers = "Accept=application/json", method = RequestMethod.POST)
    public EmployeeEntity createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        return employeeRepository.save(employeeDTO.toEntity());
    }
	
	@GetMapping("/employee/{id}")
    public EmployeeEntity getEmployeeById(@PathVariable(value = "id") Integer id) {
		return employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
    }

	
	@DeleteMapping("/employee/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Integer id) {
        EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
	
	@PutMapping("/employee/{id}")
	public EmployeeEntity replaceEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Integer id) {
		EmployeeEntity employee = employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		employee.setBirthday(employeeDTO.birthday);
		employee.setEmail(employeeDTO.email);
		employee.setFullName(employeeDTO.fullName);
		employee.setTelephone(employeeDTO.telephone);
		employee.setJoinDay(employeeDTO.joinDay);
		return employeeRepository.save(employee);
	  }
}
