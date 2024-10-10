package com.example.auth.auth.Dto;

import com.example.auth.auth.Entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private Integer empId;

    private String name;

    private Employee role;

    private String address;
    
    private String phone;

    private String email;


}
