package com.wata.payslip.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.wata.payslip.model.dto.EmployeeDTO;
import com.wata.payslip.model.dto.SearchData;
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

	public Optional<EmployeeEntity> getEmployeeById(Integer id) {
		employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		return employeeRepository.findById(id);
	}

	public String deleteEmployeeById(Integer id) {
		employeeRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
		employeeRepository.deleteById(id);
		return "ok";
	}

	public EmployeeEntity replaceEmployee(EmployeeDTO employeeDTO, Integer id) {

		EmployeeEntity employee = employeeRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException(id + ""));
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

	public ResponseEntity<Map<String, Object>> searchEmployeeByFullName(SearchData searchData) {
		String fullName = searchData.getSearchValue();
		Integer currentPage, pageSize;
		String sort = searchData.getSort();

		if (searchData.getCurrentPage() != null) {
			currentPage = searchData.getCurrentPage();
		} else {
			currentPage = 0;
		}

		if (searchData.getPageSize() != null) {
			pageSize = searchData.getPageSize();
		} else {
			pageSize = 3;
		}

		try {
			List<EmployeeEntity> employeeEntities = new ArrayList<EmployeeEntity>();
			Pageable paging;

			if (sort != null) {
				switch (sort) {
				case "ASC":
					paging = PageRequest.of(currentPage, pageSize, Sort.by("fullName"));
					break;
				case "DESC":
					paging = PageRequest.of(currentPage, pageSize, Sort.by("fullName").descending());
					break;
				default:
					paging = PageRequest.of(currentPage, pageSize);
					break;
				}
			} else {
				paging = PageRequest.of(currentPage, pageSize);
			}

			Page<EmployeeEntity> pageTuts;
			if (fullName == null) {
				pageTuts = employeeRepository.findAll(paging);
			} else {
				pageTuts = employeeRepository.findByFullNameContaining(fullName.trim(), paging);
			}

			employeeEntities = pageTuts.getContent();

			if (employeeEntities.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			Map<String, Object> response = new HashMap<>();
			response.put("currentPage", pageTuts.getNumber());
			response.put("totalItems", pageTuts.getTotalElements());
			response.put("totalPages", pageTuts.getTotalPages());
			response.put("employee", employeeEntities);

			return new ResponseEntity<>(response, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
