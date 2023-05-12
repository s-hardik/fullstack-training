package com.employee.portal.EmployeeManagementPortal.repository;

import com.employee.portal.EmployeeManagementPortal.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    public Optional<User> findByUserName(String userName);
}
