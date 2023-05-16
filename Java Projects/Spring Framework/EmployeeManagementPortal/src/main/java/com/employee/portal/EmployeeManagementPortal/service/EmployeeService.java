package com.employee.portal.EmployeeManagementPortal.service;

import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import com.employee.portal.EmployeeManagementPortal.modal.EmployeeModal;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


public interface EmployeeService {
    public Employee addEmployee(EmployeeModal employeeModal);

    public List<Employee> getAllEmployee();

    public Optional<Employee> getEmployeeById(String empId);

    public void deleteEmployeeById(String empId);

    public ResponseEntity<?> editEmployeeById(String empId, EmployeeModal employeeModal);
}
