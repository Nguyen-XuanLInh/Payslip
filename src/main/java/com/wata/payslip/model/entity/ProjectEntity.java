package com.wata.payslip.model.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Project")
public class ProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdProject")
	private Integer id;

//	@OneToMany(mappedBy = "projectEntity")
//	private List<TaskEntity> task = new ArrayList<>();

	@ManyToOne()
	@JoinColumn(name = "TypeProject", insertable = false, updatable = false)
	private TypeProjectEntity typeProjectEntity;

	@OneToMany(mappedBy = "projectEntity")
	private List<AssigmentEntity> assigment = new ArrayList<>();
	
	@Column(name = "NameProject")
	@Pattern(regexp = "[A-Za-z0-9 \\t\\n\\x0B\\f\\r\\p{L}]+")
	private String nameProject;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "Description")
	private String description;

	public ProjectEntity() {

	}

	public ProjectEntity(Integer id, TypeProjectEntity typeProjectEntity, String nameProject,
			Date startDate, Date endDate, String description) {
		super();
		this.id = id;
//		this.task = task;
		this.typeProjectEntity = typeProjectEntity;
		this.nameProject = nameProject;
		this.startDate = startDate;
		this.endDate = endDate;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNameProject() {
		return nameProject;
	}

	public void setNameProject(String nameProject) {
		this.nameProject = nameProject;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
//
//	public List<TaskEntity> getTask() {
//		return task;
//	}
//
//	public void setTask(List<TaskEntity> task) {
//		this.task = task;
//	}

	public TypeProjectEntity getTypeProjectEntity() {
		return typeProjectEntity;
	}

	public void setTypeProjectEntity(TypeProjectEntity typeProjectEntity) {
		this.typeProjectEntity = typeProjectEntity;
	}

}
