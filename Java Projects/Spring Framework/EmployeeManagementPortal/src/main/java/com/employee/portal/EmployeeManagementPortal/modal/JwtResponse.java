package com.employee.portal.EmployeeManagementPortal.modal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
@AllArgsConstructor
@Setter
@Getter
public class JwtResponse implements Serializable {

    private static final long serialVersionUID = -8091879091924046844L;
    private String token;
    private String id;
    private String username;
    private String email;
    private List<String> roles;

}
