package com.hardik.shah.springootdemo.controller;

import com.hardik.shah.springootdemo.entity.Department;
import com.hardik.shah.springootdemo.service.DepartementService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartementService departementService;
    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @PostMapping("/departments")
    public Department saveDepartment(@Valid @RequestBody Department department){
        logger.info("inside save department of departmentcontroller");
    return  departementService.saveDepartment(department);
    }
    @GetMapping("/departments")
    public List<Department> getDepatements(){
        logger.info("inside get department of departmentcontroller");
    return departementService.getDepartments();
    }
    @GetMapping("/departments/{id}")
    public Department getDepatementsById(@PathVariable("id") Long departmentId){
        return departementService.getDepartmentsById(departmentId);
    }
    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        departementService.deleteDepartmentById(departmentId);
        return "Department Deleted Successfully";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartmentById(@PathVariable("id") Long departmentId, @RequestBody Department department){
        return departementService.updateDepartmentById(departmentId, department);
    }
    @GetMapping("/departments/name/{name}")
    public Department getDepatementsByName(@PathVariable("name") String departmentName){
        return departementService.getDepatementsByName(departmentName);
    }
}

