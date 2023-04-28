package com.hardik.shah.springootdemo.service;

import com.hardik.shah.springootdemo.entity.Department;
import com.hardik.shah.springootdemo.repository.DepartmentRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigInteger;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@SpringBootTest
class DepartementServiceTest {
    @Autowired
    private DepartementService departementService;
    @MockBean
    private DepartmentRepository departmentRepository;
    @BeforeEach
    void setUp() {
        Department department = Department.builder().departmentName("IT")
                .departmentAddress("Ahemdabad")
                .departmentId("1")
                .departmentCode("008")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IT")).thenReturn(department);
    }
    @Test
    @DisplayName("Positve: Fetch Department by department Name")
    public void getDepatementsByNameTest(){
        String departmentName = "IT";
        Department found = departementService.getDepatementsByName(departmentName);
       // System.out.printf(found.getDepartmentCode());
        assertEquals(departmentName, found.getDepartmentName());
    }
}