package com.example.auth.auth.services;

import com.example.auth.auth.Dto.CreateEmployeeDto;
import com.example.auth.auth.Dto.LoginDto;

public interface AuthService {

    CreateEmployeeDto registerEmployee(CreateEmployeeDto employee);

    void login(LoginDto loginDto);

}
