package com.wata.payslip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wata.payslip.model.entity.AssigmentEntity;
import com.wata.payslip.service.AssigmentService;

@RestController
@RequestMapping("/api")
public class AssigmentController {
	@Autowired
	private AssigmentService assigmentService = new AssigmentService();

	@GetMapping("/assigment")
	public List<AssigmentEntity> getAllAssigment() {
		return assigmentService.getAllAssigment();
	}
}
