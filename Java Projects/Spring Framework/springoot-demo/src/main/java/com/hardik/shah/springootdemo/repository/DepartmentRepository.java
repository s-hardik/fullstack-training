package com.hardik.shah.springootdemo.repository;

import com.hardik.shah.springootdemo.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


public interface DepartmentRepository extends MongoRepository<Department, Long> {
    Department findByDepartmentNameIgnoreCase(String departmentName);
}
