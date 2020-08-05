//package com.wata.payslip.model.entity;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "Task")
//public class TaskEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	@Column(name = "IdTask")
//	private Integer id;
//
//	@OneToMany(mappedBy = "taskEntity")
//	private List<TimeLogEntity> timeLog = new ArrayList<>();
//
//	@ManyToOne()
//	@JoinColumn(name = "IdProject", insertable = false, updatable = false)
//	private ProjectEntity projectEntity;
//
//	@Column(name = "IdProject")
//	private Integer idProject;
//
//	@Column(name = "Summary")
//	private String summary;
//
//	@Column(name = "Explain")
//	private String explain;
//
//	public TaskEntity() {
//
//	}
//
//	public TaskEntity(Integer id, List<TimeLogEntity> timeLog, ProjectEntity projectEntity, String summary,
//			String explain) {
//		super();
//		this.id = id;
//		this.timeLog = timeLog;
//		this.projectEntity = projectEntity;
//		this.summary = summary;
//		this.explain = explain;
//	}
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getIdProject() {
//		return idProject;
//	}
//
//	public void setIdProject(Integer idProject) {
//		this.idProject = idProject;
//	}
//
//	public String getSummary() {
//		return summary;
//	}
//
//	public void setSummary(String summary) {
//		this.summary = summary;
//	}
//
//	public String getExplain() {
//		return explain;
//	}
//
//	public void setExplain(String explain) {
//		this.explain = explain;
//	}
//
//	public List<TimeLogEntity> getTimeLog() {
//		return timeLog;
//	}
//
//	public void setTimeLog(List<TimeLogEntity> timeLog) {
//		this.timeLog = timeLog;
//	}
//
//	public ProjectEntity getProjectEntity() {
//		return projectEntity;
//	}
//
//	public void setProjectEntity(ProjectEntity projectEntity) {
//		this.projectEntity = projectEntity;
//	}
//
//}
