package com.employee.portal.EmployeeManagementPortal.service;

import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import com.employee.portal.EmployeeManagementPortal.modal.EmployeeModal;
import com.employee.portal.EmployeeManagementPortal.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Override
    public Employee addEmployee(EmployeeModal employeeModal) {
       Employee employee = new Employee();
       employee.setEmpId(employeeModal.getEmpId());
       employee.setFirstName(employeeModal.getFirstName());
       employee.setMiddleName(employeeModal.getMiddleName());
       employee.setLastName(employeeModal.getLastName());
       employee.setContactNumber(employeeModal.getContactNumber());
       employee.setEmergencyNumber(employeeModal.getEmergencyNumber());
       employee.setEmail(employeeModal.getEmail());
       employee.setPanNo(employeeModal.getPanNo());
       employee.setBloodGroup(employeeModal.getBloodGroup());
       employee.setPresentAddress(employeeModal.getPresentAddress());
       employee.setPermanentAddress(employeeModal.getPermanentAddress());
       employeeRepository.save(employee);
       return employee;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> getEmployeeById(String empId) {
        System.out.printf(empId);
        return employeeRepository.findById(empId);
    }

    @Override
    public void deleteEmployeeById(String empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public ResponseEntity<?> editEmployeeById(String empId, EmployeeModal employeeModal) {
        Optional<Employee> existingEmployee = employeeRepository.findById(empId);
        if(!existingEmployee.isPresent()){
            return new ResponseEntity<>(
                    "employee not found",
                    HttpStatus.BAD_REQUEST
            );
        }
        existingEmployee.ifPresent(employee -> {
            employee.setFirstName(employeeModal.getFirstName());
            employee.setMiddleName(employeeModal.getMiddleName());
            employee.setLastName(employeeModal.getLastName());
            employee.setContactNumber(employeeModal.getContactNumber());
            employee.setEmergencyNumber(employeeModal.getEmergencyNumber());
            employee.setEmail(employeeModal.getEmail());
            employee.setPanNo(employeeModal.getPanNo());
            employee.setBloodGroup(employeeModal.getBloodGroup());
            employee.setPresentAddress(employeeModal.getPresentAddress());
            employee.setPermanentAddress(employeeModal.getPermanentAddress());
            employeeRepository.save(employee);
        });
        return new ResponseEntity<>(
                "employee Successfully Updated",
                HttpStatus.OK
        );
    }

}
