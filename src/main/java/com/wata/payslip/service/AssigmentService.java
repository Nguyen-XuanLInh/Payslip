package com.wata.payslip.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wata.payslip.model.entity.AssigmentEntity;
import com.wata.payslip.repository.IAssigmentRepository;

@Service
public class AssigmentService {

	@Autowired
	private IAssigmentRepository assigmentRepository;
	
	public List<AssigmentEntity> getAllAssigment() {
		return assigmentRepository.findAll();
	}
}
