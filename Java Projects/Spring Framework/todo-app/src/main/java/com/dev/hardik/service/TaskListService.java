package com.dev.hardik.service;

import com.dev.hardik.entity.TaskList;
import com.dev.hardik.modal.TaskListModal;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface TaskListService {
   public List<TaskList> getAllTaskList();
   public TaskList createTask(TaskListModal taskListModal);
   public Optional<TaskList> getTaskById(String taskID);

   public  String deleteTask(String taskID);
   public ResponseEntity<?> updateTaskById(String taskId, TaskListModal taskListModal);

}
