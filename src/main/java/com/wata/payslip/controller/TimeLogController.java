//package com.wata.payslip.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wata.payslip.model.dto.TimeLogDTO;
//import com.wata.payslip.model.entity.TimeLogEntity;
//import com.wata.payslip.service.TimeLogService;
//
//@RestController
//@RequestMapping("/api")
//public class TimeLogController {
//
//	@Autowired
//	private TimeLogService timeLogService = new TimeLogService();
//
//	@GetMapping("/timelog")
//	public List<TimeLogEntity> getAllTimeLog() {
//		return timeLogService.getAllTimeLog();
//	}
//
//	@PostMapping("/timelog")
//	public TimeLogEntity createTimeLog (@RequestBody TimeLogDTO timelogDTO) {
//		
//		return timeLogService.createTimeLog(timelogDTO);
//	}
//	
//	@DeleteMapping("/timelog/{id}")
//	public String deleteEmpTimelogId(@PathVariable(value = "id") Integer id) {
//		return timeLogService.deleteEmpTimelogId(id);
//	}
//	
//	
//}
