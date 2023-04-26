package com.hardik.shah.springootdemo.service;

import com.hardik.shah.springootdemo.entity.Department;

import java.util.List;

public interface DepartementService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

   public Department getDepartmentsById(Long departmentId);

   public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department getDepatementsByName(String departmentName);
}
