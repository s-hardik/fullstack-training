package com.employee.portal.EmployeeManagementPortal.repository;

import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataMongoTest
class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findAll_should_return_employee_list() {
        // When
        List<Employee> employees = this.employeeRepository.findAll();
        // Then
        assertEquals(6, employees.size());
    }

    @Test
    void findById_should_return_employee() {
        // When
        Optional<Employee> employee = this.employeeRepository.findById("645df974fea6d658dc0ed5fe");
        // Then
        assertTrue(employee.isPresent());
    }

    @Test
    void save_should_insert_new_employee() {
        // Given
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
        // When
        Employee persistedEmployee = this.employeeRepository.save(employee);
        // Then
        assertNotNull(persistedEmployee);
        assertEquals("123456", persistedEmployee.getEmpId());
    }

    @Test
    void save_should_update_existing_employee() {
        // Given
        Employee existingEmployee = new Employee();
        existingEmployee.setEmpId("3");
        existingEmployee.setFirstName("FIRST_NAME");
        existingEmployee.setLastName("LAST_NAME");
        // When
        Employee updatedEmployee = this.employeeRepository.save(existingEmployee);
        // Then
        assertNotNull(updatedEmployee);
        assertEquals("FIRST_NAME", updatedEmployee.getFirstName());
        assertEquals("LAST_NAME", updatedEmployee.getLastName());
    }

    @Test
    void deleteById_should_delete_employee() {
        // When
        this.employeeRepository.deleteById("123456");
        Optional<Employee> employee = this.employeeRepository.findById("123456");
        // Then
        assertFalse(employee.isPresent());
    }
}