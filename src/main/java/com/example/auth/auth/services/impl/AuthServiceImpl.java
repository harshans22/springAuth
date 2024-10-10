package com.example.auth.auth.services.impl;

import org.springframework.stereotype.Service;

import com.example.auth.auth.Dto.CreateEmployeeDto;
import com.example.auth.auth.Dto.LoginDto;
import com.example.auth.auth.Entity.Employee;
import com.example.auth.auth.Repository.EmployeeRepository;
import com.example.auth.auth.services.AuthService;


@Service
public class AuthServiceImpl implements AuthService {

    private final EmployeeRepository employeeRepository;

    public AuthServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public CreateEmployeeDto registerEmployee(CreateEmployeeDto employee) {
        //updating data in employee entity from employee dto
        Employee employeeEntity = new Employee();
        employeeEntity.setName(employee.getName());
        employeeEntity.setAddress(employee.getAddress());
        employeeEntity.setPhone(employee.getPhone());
        employeeEntity.setPassword(employee.getPassword());
        employeeEntity.setEmail(employee.getEmail());

        //saving data in database
        
        Employee savedEmployee = employeeRepository.save(employeeEntity);

        //updating data in employee dto from employee entity

        CreateEmployeeDto savedEmployeeDto = new CreateEmployeeDto();
        savedEmployeeDto.setName(savedEmployee.getName());
        savedEmployeeDto.setAddress(savedEmployee.getAddress());
        savedEmployeeDto.setPhone(savedEmployee.getPhone());
        savedEmployeeDto.setPassword(savedEmployee.getPassword());
        savedEmployeeDto.setEmail(savedEmployee.getEmail());
        return savedEmployeeDto;
    }

    @Override
    public void login(LoginDto loginDto) {
        Employee employee = employeeRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new RuntimeException("Employee not found"));
        if(!employee.getPassword().equals(loginDto.getPassword())){
            throw new RuntimeException("Invalid password");
        }
    }
    
}
