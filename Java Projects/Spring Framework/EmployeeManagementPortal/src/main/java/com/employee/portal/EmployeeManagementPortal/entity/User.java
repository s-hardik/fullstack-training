package com.employee.portal.EmployeeManagementPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "UserDetails")
public class User {
    @MongoId
    private String id;
    private String userName;
    private String password;
    private List<String> roles;
}
