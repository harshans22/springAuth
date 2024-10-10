package com.example.auth.auth.services;

import com.example.auth.auth.Dto.EmployeeDto;

public interface EmployeeService {

    EmployeeDto getEmployeeDataById(Integer empId);

    EmployeeDto getEmployeeByemail(String email);
    
    EmployeeDto updateEmployeeData(Integer empId, EmployeeDto employeeDto);
}
