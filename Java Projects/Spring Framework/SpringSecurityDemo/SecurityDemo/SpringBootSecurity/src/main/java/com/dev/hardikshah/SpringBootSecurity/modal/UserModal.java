package com.dev.hardikshah.SpringBootSecurity.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModal {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private  String matchingPassword;
}
