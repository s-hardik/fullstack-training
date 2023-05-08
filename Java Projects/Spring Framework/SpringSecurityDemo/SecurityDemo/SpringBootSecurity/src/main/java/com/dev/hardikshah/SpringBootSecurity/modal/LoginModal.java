package com.dev.hardikshah.SpringBootSecurity.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModal {
    private String username;
    private String password;
}
