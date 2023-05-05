package com.dev.hardikshah.SpringBootSecurity.service;

import com.dev.hardikshah.SpringBootSecurity.entity.User;
import com.dev.hardikshah.SpringBootSecurity.entity.VerificationToken;
import com.dev.hardikshah.SpringBootSecurity.modal.UserModal;

import java.util.Optional;

public interface UserService {
   public User registerUser(UserModal userModal);

   public void saveVerificationTokenForUser(String token, User user);

   String validateVerifictionToken(String token);

   VerificationToken generateNewVerificationToken(String oldToken);

   User findUserByEmail(String email);

   void createPasswordResetTokenForUser(User user, String token);

   String validatePasswordResetToken(String token);

   Optional<User> getUserByPasswordResetToken(String token);

   void changePassword(User user, String newPassword);

   boolean checkIfValidOldPassword(User user, String oldPassword);
}
