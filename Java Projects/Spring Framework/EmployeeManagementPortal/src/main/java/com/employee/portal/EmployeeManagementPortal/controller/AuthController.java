package com.employee.portal.EmployeeManagementPortal.controller;

import com.employee.portal.EmployeeManagementPortal.config.JwtTokenUtil;
import com.employee.portal.EmployeeManagementPortal.modal.JwtResponse;
import com.employee.portal.EmployeeManagementPortal.modal.UserModal;
import com.employee.portal.EmployeeManagementPortal.service.UserService;
import com.employee.portal.EmployeeManagementPortal.service.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:3000/")
@Slf4j
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UserServiceImpl userDetailsService;

    @PostMapping(value = "/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody UserModal userModal) throws Exception {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                userModal.getUserName(), userModal.getPassword()));
        System.out.println("authenticaton error"+ authentication);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(userModal.getUserName());

        System.out.println("userDetails****"+userDetails);
        System.out.println("UserName****"+userDetails.getUsername());
        System.out.println("UserName getAuthorities****"+userDetails.getAuthorities());
        final String token = jwtTokenUtil.generateToken(userDetails);
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());
        log.info(token);
        return ResponseEntity.ok(new JwtResponse(token,"",userDetails.getUsername(),"",roles));
    }
    @PostMapping(value = "/register")
    public ResponseEntity<?> saveUser(@RequestBody UserModal userModal) throws Exception {
        return ResponseEntity.ok(userDetailsService.saveUser(userModal));
    }
    @GetMapping(value = "/signout")
    public ResponseEntity<?> signout() throws Exception {
        return ResponseEntity.ok("User SignOut Successfully");
    }
}
