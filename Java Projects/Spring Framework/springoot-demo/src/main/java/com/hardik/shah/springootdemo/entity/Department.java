package com.hardik.shah.springootdemo.entity;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document
public class Department {
    @Id
    @Indexed(unique = true)
    private String departmentId;
    @NotBlank(message = "Department name is mandatory!!")
    private String departmentName;
    private String departmentAddress;
    private  String departmentCode;

}
