package com.employee.portal.EmployeeManagementPortal.controller;

import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import com.employee.portal.EmployeeManagementPortal.modal.EmployeeModal;
import com.employee.portal.EmployeeManagementPortal.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")

    public String addEmployee(@RequestBody EmployeeModal employeeModal){
        employeeService.addEmployee(employeeModal);
        return "Employee Added Successfully";
    }

    @GetMapping("/getAllEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

    @GetMapping("/getEmployeeById")
    public Optional<Employee> getEmployeeById(@RequestParam("empId") String empId) {
        return employeeService.getEmployeeById(empId);
    }

    @DeleteMapping("/deleteEmployeeById")
    public String deleteEmployeeById(@RequestParam("empId") String empId){
        employeeService.deleteEmployeeById(empId);
        return "Employee Deleted Successfully";
    }

    @PutMapping("/editEmployee")
    public ResponseEntity<?> editEmployeeById(@RequestParam("empId") String empId, @RequestBody EmployeeModal employeeModal){
        return employeeService.editEmployeeById(empId, employeeModal);
    }
    @GetMapping("/getEmployeeByEmailId")
    public Optional<Employee> getEmployeeByEmailId(@RequestParam("emailId") String emailId) {
        return Optional.ofNullable(employeeService.getEmployeeByEmailId(emailId));
    }
}
