package com.wata.payslip.model.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TypeProject")
public class TypeProjectEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IdTypeProject")
	private Integer id;

	@Column(name = "TypeName")
	private String typeName;

	@OneToMany(mappedBy = "typeProjectEntity")
	private List<ProjectEntity> project = new ArrayList<>();

	public TypeProjectEntity() {

	}

	public TypeProjectEntity(Integer id, String typeName, List<ProjectEntity> project) {
		super();
		this.id = id;
		this.typeName = typeName;
		this.project = project;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<ProjectEntity> getProject() {
		return project;
	}

	public void setProject(List<ProjectEntity> project) {
		this.project = project;
	}

}
