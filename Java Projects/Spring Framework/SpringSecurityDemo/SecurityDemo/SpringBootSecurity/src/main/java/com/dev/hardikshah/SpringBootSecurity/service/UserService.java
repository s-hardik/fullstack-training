package com.dev.hardikshah.SpringBootSecurity.service;

import com.dev.hardikshah.SpringBootSecurity.entity.User;
import com.dev.hardikshah.SpringBootSecurity.entity.VerificationToken;
import com.dev.hardikshah.SpringBootSecurity.modal.UserModal;

public interface UserService {
   public User registerUser(UserModal userModal);

   public void saveVerificationTokenForUser(String token, User user);

   String validateVerifictionToken(String token);

   VerificationToken generateNewVerificationToken(String oldToken);
}
