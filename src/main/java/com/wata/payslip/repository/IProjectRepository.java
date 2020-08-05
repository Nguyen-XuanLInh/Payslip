package com.wata.payslip.repository;

import org.springframework.stereotype.Repository;

import com.wata.payslip.model.entity.ProjectEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Repository
@EnableJpaRepositories
public interface IProjectRepository extends JpaRepository<ProjectEntity, Integer> {

}
