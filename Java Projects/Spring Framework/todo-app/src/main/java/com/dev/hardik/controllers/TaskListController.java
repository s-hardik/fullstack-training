package com.dev.hardik.controllers;

import com.dev.hardik.entity.TaskList;
import com.dev.hardik.modal.TaskListModal;
import com.dev.hardik.service.TaskListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
public class TaskListController {

    @Autowired
    private TaskListService taskListService;
    @GetMapping("api/todoapp/tasks")
    public List<TaskList> getAllTaskList(){
      return taskListService.getAllTaskList();
    }
    @GetMapping("api/todoapp/tasks/:{taskId}")
    public Optional<TaskList> createTask(@RequestParam("taskId") String taskId){
      return  taskListService.getTaskById(taskId);

    }
    @PostMapping("api/todoapp/tasks")
    public String createTask(@RequestBody TaskListModal taskListModal){
        taskListService.createTask(taskListModal);
        return "Task Added successfully";
    }

    @DeleteMapping("/api/todoapp/tasks")
    public String deleteTask(@RequestParam("taskId") String taskID){
        taskListService.deleteTask(taskID);
        return "Task Deleted Successfully";
    }

    @PutMapping("/api/todoapp/tasks")
    public ResponseEntity<?> updateTaskById(@RequestParam("taskId") String taskId, @RequestBody TaskListModal taskListModal){
        return taskListService.updateTaskById(taskId, taskListModal);
    }
}
