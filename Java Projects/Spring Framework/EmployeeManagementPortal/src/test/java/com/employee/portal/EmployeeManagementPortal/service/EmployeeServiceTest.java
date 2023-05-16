package com.employee.portal.EmployeeManagementPortal.service;

import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import com.employee.portal.EmployeeManagementPortal.modal.EmployeeModal;
import com.employee.portal.EmployeeManagementPortal.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {
    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;
    @Test
    void findAll_should_return_employee_list() {
        // Given
        Employee employee = this.buildTestingEmployee();
        // When
        when(employeeRepository.findAll()).thenReturn(List.of(employee));
        List<Employee> employees = this.employeeService.getAllEmployee();
        // Then
        assertEquals(1, employees.size());
        verify(this.employeeRepository).findAll();
    }

    @Test
    void findById_should_return_employee() {
        // Given
        Employee employee = this.buildTestingEmployee();
        // When
        when(employeeRepository.findById("123456")).thenReturn(Optional.of(employee));
        Optional<Employee> returnedEmployee = this.employeeService.getEmployeeById("123456");
        // Then
        assertEquals(employee.getEmpId(), returnedEmployee.get()
                .getEmpId());
        verify(this.employeeRepository).findById("123456");
    }

    @Test
    void save_should_insert_new_employee() {
        // Given
        Employee employee = this.buildTestingEmployee();
        // When
        //this.employeeService.addEmployee(employee);
        // Then
        verify(this.employeeRepository).save(employee);
    }

    @Test
    void deleteById_should_delete_employee() {
        // When
        this.employeeService.deleteEmployeeById("123456");
        // Then
        verify(this.employeeRepository).deleteById("123456");
    }

    private Employee buildTestingEmployee() {
        Employee employee = new Employee();
        employee.setEmpId("123456");
        employee.setFirstName("Unit Test");
        employee.setMiddleName("Test Middle Name");
        employee.setLastName("Test Last Name");
        employee.setContactNumber("1234567890");
        employee.setEmergencyNumber("1234567890");
        employee.setEmail("Test@test.com");
        employee.setPanNo("IXXXXXXXXX");
        employee.setBloodGroup("A+");
        employee.setPresentAddress("Test City");
        employee.setPermanentAddress("Test City");
        return employee;
    }
}