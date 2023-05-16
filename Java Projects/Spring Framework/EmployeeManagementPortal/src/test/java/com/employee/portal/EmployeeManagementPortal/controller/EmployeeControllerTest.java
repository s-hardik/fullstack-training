package com.employee.portal.EmployeeManagementPortal.controller;

import com.employee.portal.EmployeeManagementPortal.config.JwtRequestFilter;
import com.employee.portal.EmployeeManagementPortal.config.JwtTokenUtil;
import com.employee.portal.EmployeeManagementPortal.entity.Employee;
import com.employee.portal.EmployeeManagementPortal.modal.EmployeeModal;
import com.employee.portal.EmployeeManagementPortal.repository.EmployeeRepository;
import com.employee.portal.EmployeeManagementPortal.repository.UserRepository;
import com.employee.portal.EmployeeManagementPortal.service.EmployeeService;
import com.employee.portal.EmployeeManagementPortal.service.EmployeeServiceImpl;
import com.employee.portal.EmployeeManagementPortal.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.*;

import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest
class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EmployeeServiceImpl employeeService;
    @MockBean
    private UserServiceImpl userService;

    @MockBean
    private AuthenticationManager authenticationManager;
    @MockBean
    private EmployeeRepository employeeRepository;
    @MockBean
    private UserRepository userRepository;
    @MockBean
    private JwtTokenUtil jwtTokenUtil;
    private Employee employeeModal;

    @Autowired
    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp() {

        employeeModal = new Employee();
        employeeModal.setEmpId("123456");
        employeeModal.setFirstName("Unit Test");
        employeeModal.setMiddleName("Test Middle Name");
        employeeModal.setLastName("Test Last Name");
        employeeModal.setContactNumber("1234567890");
        employeeModal.setEmergencyNumber("1234567890");
        employeeModal.setEmail("Test@test.com");
        employeeModal.setPanNo("IXXXXXXXXX");
        employeeModal.setBloodGroup("A+");
        employeeModal.setPresentAddress("Test City");
        employeeModal.setPermanentAddress("Test City");
    }
    @WithMockUser("hshah")
    @Test
    void addEmployee() throws Exception {

        when(employeeService.addEmployee(any(EmployeeModal.class))).thenReturn(employeeModal);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/addEmployee")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeModal)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Employee Added Successfully")));

    }
    @WithMockUser("hshah")
    @Test
    void getAllEmployee() throws Exception {
        List<Employee> list = new ArrayList<>();
        list.add(employeeModal);

        when(employeeService.getAllEmployee()).thenReturn(list);

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getAllEmployee").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").isNotEmpty());
    }
    @WithMockUser("hshah")
    @Test
    void getEmployeeById() throws Exception {
        when(employeeService.getEmployeeById(anyString())).thenReturn(Optional.ofNullable(employeeModal));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/getEmployeeById").param("empId","123456"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.firstName").value("Unit Test"))
                .andExpect(jsonPath("$.empId").value("123456"))
                .andExpect(jsonPath("$.bloodGroup").value("A+"))
                .andDo(print());
    }
    @WithMockUser("hshah")
    @Test
    void deleteEmployeeById() throws Exception {
        doNothing().when(employeeService).deleteEmployeeById(anyString());

        this.mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmployeeById").param("empId","123456").with(csrf()))
                .andExpect(status().isOk());
    }
    @WithMockUser("hshah")
    @Test
    void editEmployeeById() throws Exception {
        when(employeeService.editEmployeeById(anyString(), any(EmployeeModal.class))).thenReturn(new ResponseEntity<>(
                HttpStatus.OK
        ));
        this.mockMvc.perform(MockMvcRequestBuilders.put("/editEmployee").param("empId","123456")
                        .with(csrf())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(employeeModal)))
                .andExpect(status().isOk());
    }

}