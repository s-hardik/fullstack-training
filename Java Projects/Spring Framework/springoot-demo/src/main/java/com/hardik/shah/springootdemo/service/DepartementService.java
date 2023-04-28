package com.hardik.shah.springootdemo.service;

import com.hardik.shah.springootdemo.entity.Department;
import com.hardik.shah.springootdemo.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartementService {
    public Department saveDepartment(Department department);

    public List<Department> getDepartments();

   public Department getDepartmentsById(Long departmentId) throws DepartmentNotFoundException;

   public void deleteDepartmentById(Long departmentId);

    public Department updateDepartmentById(Long departmentId, Department department);

    public Department getDepatementsByName(String departmentName);
}
