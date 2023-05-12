package com.employee.portal.EmployeeManagementPortal.modal;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserModal implements Serializable {
    private String userName;
    private String password;
    private List<String> roles;
}
