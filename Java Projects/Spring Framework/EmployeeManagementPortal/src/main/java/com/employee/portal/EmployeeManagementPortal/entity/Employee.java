package com.employee.portal.EmployeeManagementPortal.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "EmployeeDetails")
public class Employee {
    @MongoId
    private String empId;
    private String firstName;
    private  String middleName;
    private  String lastName;
    private  String contactNumber;
    private  String emergencyNumber;
    private String email;
    private String panNo;
    private  String bloodGroup;
    private String presentAddress;
    private String permanentAddress;
}