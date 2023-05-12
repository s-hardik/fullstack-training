package com.employee.portal.EmployeeManagementPortal.service;

import com.employee.portal.EmployeeManagementPortal.entity.User;
import com.employee.portal.EmployeeManagementPortal.modal.UserModal;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    User saveUser(UserModal userModal);
}
