package com.wata.payslip.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Assigment")
public class AssigmentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdAssigment")
	private Integer id;

	@ManyToOne()
	@JoinColumn(name = "IdProject", insertable = false, updatable = false)
	private ProjectEntity projectEntity;

	@ManyToOne()
	@JoinColumn(name = "IdEmployee", insertable = false, updatable = false)
	private EmployeeEntity employeeEntity;

	public AssigmentEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AssigmentEntity(Integer id, ProjectEntity projectEntity, EmployeeEntity employeeEntity) {
		super();
		this.id = id;
		this.projectEntity = projectEntity;
		this.employeeEntity = employeeEntity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProjectEntity getProjectEntity() {
		return projectEntity;
	}

	public void setProjectEntity(ProjectEntity projectEntity) {
		this.projectEntity = projectEntity;
	}

	public EmployeeEntity getEmployeeEntity() {
		return employeeEntity;
	}

	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
		this.employeeEntity = employeeEntity;
	}

}
