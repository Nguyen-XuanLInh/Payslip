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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.wata.payslip.model.dto.EmployeeDTO;
import com.wata.payslip.model.dto.PaginationList;
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
	
	@GetMapping("/employee/search")
    public List <EmployeeEntity> getEmployeeByName(@RequestParam() String fullName) {
		return employeeService.getEmployeeByName(fullName);
    }
	
	@RequestMapping(value = "/employee/search", headers = "Accept=application/json", method = RequestMethod.POST)
    public List<EmployeeEntity> createSearchEmployee(@RequestBody EmployeeDTO employeeDTO) {	
		return employeeService.createSearchEmployee(employeeDTO);
    }
	
	@RequestMapping(value = "/employee/timkiem", headers = "Accept=application/json", method = RequestMethod.POST)
	public String showHello(@RequestParam(value="param1", required=true) String parameter1,
			@RequestParam(value="param2", required=false) String parameter2) {
		return parameter1 + ":" + parameter2;
	}
	
//	@RequestMapping(value = "/employee/page", headers = "Accept=application/json", method = RequestMethod.POST)
//	  public PaginationList<EmployeeEntity> getAllEmployee2(@RequestBody searchString searchstring) {
//	
//		return employeeService.findByFullName(searchstring.searString, searchstring.currentPage - 1, searchstring.pageSize);
//	  }
	
	@PostMapping("/employee/test") 
	public String testPost() {
		return "post";
	}
	
	@GetMapping("/employee/test") 
	public String testGet() {
		return "get";
	}
	
	@PutMapping("/employee/test") 
	public String testPut() {
		return "put";
	}
	
////	@PostMapping("/employee/page")
////	  public ResponseEntity<Map<String, Object>> getAllEmployee2(
////	        @RequestParam(required = false) String fullName,
////	        @RequestParam(defaultValue = "0") int page,
////	        @RequestParam(defaultValue = "3") int size
////	      ) {
////
////		return employeeService.findByFullName(fullName, page, size);
////	  }
//	
//	@GetMapping("/employee/pages")
//	public List <EmployeeEntity> findAll() {
//		return employeeService.getAllEmployee();
//	}
//	
//	@PostMapping("/employee/pages")
//	public List <EmployeeEntity> findByFullName(@RequestBody A a) {
//		return employeeService.findByFullName(a.fullName);
//	}
//	
//	public static class A {
//		String fullName = "";
//		String b = "";
//	}
//	
//	public static class B {
//		String b = "";
//	}
	
	/**
	 * 
	 */
	
	@PostMapping("/employee/pages")
	public ResponseEntity<Map<String, Object>> searchEmployeeByFullName(@RequestBody SearchData searchData) {
		//default currentPage = 0, pageSize = 3
		return employeeService.searchEmployeeByFullName(searchData);
	}
}
