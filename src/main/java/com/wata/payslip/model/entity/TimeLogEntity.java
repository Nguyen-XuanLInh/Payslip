//package com.wata.payslip.model.entity;
//
//import java.sql.Time;
//import java.sql.Timestamp;
//import java.util.Date;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "TimeLog")
//public class TimeLogEntity {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Integer id;
//
//	@ManyToOne()
//	@JoinColumn(name = "IdEmployee", insertable = false, updatable = false)
//	private EmployeeEntity employeeEntity;
//
//	@ManyToOne()
//	@JoinColumn(name = "IdTask", insertable = false, updatable = false)
//	private TaskEntity taskEntity;
//
//	@Column(name = "StartTime")
//	private Timestamp startTime;
//
//	@Column(name = "EndTime")
//	private Timestamp endTime;
//
//	@Column(name = "Hour")
//	private Time hour;
//
//	public TimeLogEntity() {
//
//	}
//
//	public TimeLogEntity(Integer id, EmployeeEntity employeeEntity, TaskEntity taskEntity, Timestamp startTime,
//			Timestamp endTime, Time hour) {
//		super();
//		this.id = id;
//		this.employeeEntity = employeeEntity;
//		this.taskEntity = taskEntity;
//		this.startTime = startTime;
//		this.endTime = endTime;
//		this.hour = hour;
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
//	public Date getStartTime() {
//		return startTime;
//	}
//
//	public void setStartTime(Timestamp startTime) {
//		this.startTime = startTime;
//	}
//
//	public Date getEndTime() {
//		return endTime;
//	}
//
//	public void setEndTime(Timestamp endTime) {
//		this.endTime = endTime;
//	}
//
//	public Time getHour() {
//		return hour;
//	}
//
//	public void setHour(Time hour) {
//		this.hour = hour;
//	}
//
//	public EmployeeEntity getEmployeeEntity() {
//		return employeeEntity;
//	}
//
//	public void setEmployeeEntity(EmployeeEntity employeeEntity) {
//		this.employeeEntity = employeeEntity;
//	}
//
//	public TaskEntity getTaskEntity() {
//		return taskEntity;
//	}
//
//	public void setTaskEntity(TaskEntity taskEntity) {
//		this.taskEntity = taskEntity;
//	}
//
//}
