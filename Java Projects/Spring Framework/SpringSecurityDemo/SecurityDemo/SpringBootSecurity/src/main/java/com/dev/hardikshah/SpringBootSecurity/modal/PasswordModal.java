package com.dev.hardikshah.SpringBootSecurity.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PasswordModal {
    private String email;
    private String oldPassword;
    private String newPassword;
}
