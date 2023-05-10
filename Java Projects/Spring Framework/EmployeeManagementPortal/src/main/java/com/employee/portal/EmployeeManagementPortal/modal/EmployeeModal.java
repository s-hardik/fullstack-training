package com.employee.portal.EmployeeManagementPortal.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModal {
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
