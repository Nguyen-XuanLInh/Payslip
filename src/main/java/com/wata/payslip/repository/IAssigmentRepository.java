package com.wata.payslip.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wata.payslip.model.entity.AssigmentEntity;

public interface IAssigmentRepository extends JpaRepository<AssigmentEntity, Integer> {

}
