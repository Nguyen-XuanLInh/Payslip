//package com.wata.payslip.model.dto;
//
//import java.sql.Time;
//import java.sql.Timestamp;
//
//import com.wata.payslip.model.entity.EmployeeEntity;
//import com.wata.payslip.model.entity.TaskEntity;
//import com.wata.payslip.model.entity.TimeLogEntity;
//
//public class TimeLogDTO {
//
//	public Integer id;
//	public Timestamp startTime;
//	public Timestamp endTime;
//	public Time hour;
//	public EmployeeEntity employeeEntity;
//	public TaskEntity taskEntity;
//	public TimeLogEntity toEntity() {
//		return new TimeLogEntity(id, employeeEntity, taskEntity, startTime, endTime, hour);
//	}
//	
//}
