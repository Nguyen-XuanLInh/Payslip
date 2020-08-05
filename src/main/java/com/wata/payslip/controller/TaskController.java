//package com.wata.payslip.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.wata.payslip.model.dto.TaskDTO;
//import com.wata.payslip.model.entity.TaskEntity;
//import com.wata.payslip.service.TaskService;
//
//@RestController
//@RequestMapping("/api")
//public class TaskController {
//
//	@Autowired
//	private TaskService taskService = new TaskService();
//
//	@GetMapping("/task")
//	public List<TaskEntity> getAllTask() {
//		return taskService.getAllTask();
//	}
//	
//	@PostMapping("/task")
//	public TaskEntity createTask(@RequestBody TaskDTO task) {
//		return taskService.createTask(task);
//	}
//	
//	@DeleteMapping("/task/{id}")
//	public String deleteTaskById(@PathVariable(value = "id") Integer id) {
//		return taskService.deleteTaskById(id);
//	}
//
//	@PutMapping("/task/{id}")
//	public TaskEntity replaceTask(@RequestBody TaskDTO task, @PathVariable Integer id) {
//		return taskService.replaceTask(task, id);
//	}
//	
//}
