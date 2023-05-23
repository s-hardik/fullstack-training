package com.employee.portal.EmployeeManagementPortal.service;

import com.employee.portal.EmployeeManagementPortal.entity.User;
import com.employee.portal.EmployeeManagementPortal.modal.UserModal;
import com.employee.portal.EmployeeManagementPortal.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public User saveUser(UserModal userModal) {
        List<String> roles = userModal.getRoles();
        System.out.println("ROles****"+roles);
        User user = new User();
        String passwd= userModal.getPassword();
        String encodedPasswod = passwordEncoder.encode(passwd);
        user.setPassword(encodedPasswod);
        user.setUserName(userModal.getUserName());
        user.setEmail(userModal.getEmail());
        user.setRoles(userModal.getRoles());
        userRepo.save(user);
        return user;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> opt = userRepo.findByUserName(username);
        org.springframework.security.core.userdetails.User springUser=null;

        if(opt.isEmpty()) {
            throw new UsernameNotFoundException("User " + username +" not found");
        }
        User user =opt.get();
        List<String> roles = user.getRoles();
        Set<GrantedAuthority> ga = new HashSet<>();
        for(String role:roles) {
            ga.add(new SimpleGrantedAuthority(role));
        }
        return new MySpringUser(user);
    }
}
