package com.dev.hardik.service;

import com.dev.hardik.entity.TaskList;
import com.dev.hardik.modal.TaskListModal;
import com.dev.hardik.repository.TaskListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskListServiceImpl implements TaskListService {
    @Autowired
    private TaskListRepository taskListRepository;
    @Override
    public List<TaskList> getAllTaskList() {
        return taskListRepository.findAll();
    }

    @Override
    public TaskList createTask(TaskListModal taskListModal) {
        TaskList taskList = new TaskList();
        taskList.setTaskName(taskListModal.getTaskName());
        taskList.setCreatedDate(taskListModal.getCreatedDate());
        taskList.setTaskDescription(taskListModal.getTaskDescription());
        taskList.setFinishTragetDate(taskListModal.getFinishTragetDate());
        taskList.setStatus(taskListModal.getStatus());

        return taskListRepository.save(taskList);
    }

    @Override
    public Optional<TaskList> getTaskById(String taskID) {
        return taskListRepository.findById(taskID);
    }

    @Override
    public String deleteTask(String taskID) {
        taskListRepository.deleteById(taskID);
        return "Task deleted successfully!!";
    }

    @Override
    public ResponseEntity<?> updateTaskById(String taskId, TaskListModal taskListModal) {
        Optional<TaskList> tasks = taskListRepository.findById(taskId);
        if(!tasks.isPresent()){
            return new ResponseEntity<>(
                    "employee not found",
                    HttpStatus.BAD_REQUEST
            );
        }
        tasks.ifPresent(task -> {
            task.setTaskName(taskListModal.getTaskName());
            task.setTaskDescription(taskListModal.getTaskDescription());
            task.setFinishTragetDate(taskListModal.getFinishTragetDate());
            task.setStatus(taskListModal.getStatus());

            taskListRepository.save(task);
        });
        return new ResponseEntity<>(
                "employee Successfully Updated",
                HttpStatus.OK
        );
    }
}
