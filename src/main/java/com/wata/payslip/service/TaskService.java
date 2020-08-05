//package com.wata.payslip.service;
//
//import java.util.List;
//
//import javax.persistence.EntityNotFoundException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.wata.payslip.model.dto.TaskDTO;
//import com.wata.payslip.model.entity.TaskEntity;
//import com.wata.payslip.repository.ITaskRepository;
//
//@Service
//public class TaskService {
//	@Autowired
//	private ITaskRepository taskRepository;
//
//	public List<TaskEntity> getAllTask() {
//		return taskRepository.findAll();
//	}
//	
//	public TaskEntity createTask(TaskDTO task) {
//		return taskRepository.save(task.toEntity());
//	}
//	
//	public String deleteTaskById(Integer id) {
//		taskRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id + ""));
//		taskRepository.deleteById(id);
//		return "ok";
//	}
//	
//	public TaskEntity replaceTask(TaskDTO taskDTO, Integer id) {
//
//		TaskEntity task = taskRepository.findById(id)
//				.orElseThrow(() -> new EntityNotFoundException(id + ""));
//		if (taskDTO.summary != null) {
//			task.setSummary(taskDTO.summary);
//		}
//
//		if (taskDTO.explain != null) {
//			task.setExplain(taskDTO.explain);
//		}
//
//		return taskRepository.save(task);
//	}
//
//	
//
//}
