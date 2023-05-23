package com.employee.portal.EmployeeManagementPortal.repository;

import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, String> {
    Employee getEmployeeByEmail(String emailId);
}
