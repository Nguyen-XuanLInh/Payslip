//package com.wata.payslip.service;
//
//import java.util.List;
//
//import javax.persistence.EntityNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.wata.payslip.model.dto.TimeLogDTO;
//import com.wata.payslip.model.entity.TimeLogEntity;
//import com.wata.payslip.repository.ITimeLogRepository;
//
//@Service
//public class TimeLogService {
//	@Autowired
//	private ITimeLogRepository timelogRepository;
//
//	public List<TimeLogEntity> getAllTimeLog() {
//		return timelogRepository.findAll();
//	}
//
//	public TimeLogEntity createTimeLog(TimeLogDTO timelog) {
//		return timelogRepository.save(timelog.toEntity());
//	}
//
//	public String deleteEmpTimelogId(Integer id) {
//		timelogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
//		timelogRepository.deleteById(id);
//		return "OK";
//	}
//
//}
