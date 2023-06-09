package com.dev.hardikshah.SpringBootSecurity.controller;

import com.dev.hardikshah.SpringBootSecurity.entity.User;
import com.dev.hardikshah.SpringBootSecurity.entity.VerificationToken;
import com.dev.hardikshah.SpringBootSecurity.events.RegistrationCompleteEvent;
import com.dev.hardikshah.SpringBootSecurity.modal.PasswordModal;
import jakarta.servlet.http.HttpServletRequest;
import com.dev.hardikshah.SpringBootSecurity.modal.UserModal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.*;
import com.dev.hardikshah.SpringBootSecurity.service.UserService;

import java.security.PublicKey;
import java.util.Optional;
import java.util.UUID;

@RestController
@Slf4j
public class RegisterController {
    @Autowired
    private UserService userService;
    @Autowired
    private ApplicationEventPublisher publisher;
    @GetMapping("/")
    public String helloWorld(){
        return "Hello to the first spring boot application";
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody UserModal userModal, final HttpServletRequest request){
    User user = userService.registerUser(userModal);
    publisher.publishEvent(new RegistrationCompleteEvent(user, applicationUrl(request)));
    return "Success";
    }
    @GetMapping("/verifyRegistration")
    public String verifyRegistration(@RequestParam("token") String token){
        String result = userService.validateVerifictionToken(token);
        if(result.equalsIgnoreCase("valid")){
            return "User Verifies Successfully!!";
        }
        else{
            return "Bad user!!";
        }
    }
    @GetMapping("/resendVerifyToken")
    public String resendVerificationToken(@RequestParam("token") String oldToken, HttpServletRequest request){
        VerificationToken verificationToken = userService.generateNewVerificationToken(oldToken);
        User user = verificationToken.getUser();
        resendVerificationTokenMail(user,applicationUrl(request), verificationToken);
        return "Verification Link Send!!";
    }
    @PostMapping("/resetPassword")
    public String resetPassword(@RequestBody PasswordModal passwordModal, HttpServletRequest request){
        User user = userService.findUserByEmail(passwordModal.getEmail());
        String url = null;
        if(user!=null){
            String token = UUID.randomUUID().toString();
            userService.createPasswordResetTokenForUser(user,token);
            url = passwordResetTokenMail(user, applicationUrl(request), token);
        }
        return url;
    }
    @PostMapping("/savePassword")
    public String savePassoword(@RequestParam("token") String token, @RequestBody PasswordModal passwordModal){
        String result = userService.validatePasswordResetToken(token);
        if(!result.equalsIgnoreCase("valid")){
            return "Invalid Token";
        }
        Optional<User> user = userService.getUserByPasswordResetToken(token);
        if(user.isPresent()){
            userService.changePassword(user.get(), passwordModal.getNewPassword());
            return "Password reset Successfull!!";
        }
        else{
            return "Invalid Token";
        }
    }
    @PostMapping("/changePassword")
    public String changePassword(@RequestBody PasswordModal passwordModal){
        User user = userService.findUserByEmail(passwordModal.getEmail());
        if(!userService.checkIfValidOldPassword(user, passwordModal.getOldPassword())){
            return "Invalid Old password";
        }
        userService.changePassword(user, passwordModal.getNewPassword());
        return "Passoword Changed Successfully";
    }

    private String passwordResetTokenMail(User user, String applicationUrl, String token) {
        String url = applicationUrl +"/savePassword?token=" + token;
        log.info("Click the link to reset your password: {}", url);
        return url;
    }

    private void resendVerificationTokenMail(User user, String applicationUrl, VerificationToken verificationToken) {
        String url = applicationUrl +"/verifyRegistration?token=" + verificationToken.getToken();
        log.info("Click the link to verify your account: {}", url);

    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName()
                + ":" + request.getServerPort() + request.getContextPath();
    }
}
