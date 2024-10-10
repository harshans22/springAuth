package com.example.auth.auth.services.impl;

import org.springframework.stereotype.Service;

import com.example.auth.auth.Dto.EmployeeDto;
import com.example.auth.auth.Entity.Employee;
import com.example.auth.auth.Repository.EmployeeRepository;
import com.example.auth.auth.services.EmployeeService;

@Service
public class EmployeeServiceImpl implements  EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public EmployeeDto getEmployeeDataById(Integer empId) {
       Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
         EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setName(employee.getName());
            employeeDto.setAddress(employee.getAddress());
            employeeDto.setPhone(employee.getPhone());
            employeeDto.setEmail(employee.getEmail());
            return employeeDto;
    }

    @Override
    public EmployeeDto getEmployeeByemail(String email) {
        Employee employee = employeeRepository.findByEmail(email).orElseThrow(() -> new RuntimeException("Employee not found"));
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setName(employee.getName());
        employeeDto.setAddress(employee.getAddress());
        employeeDto.setPhone(employee.getPhone());
        employeeDto.setEmail(employee.getEmail());
        return employeeDto;
    }

    @Override
    public EmployeeDto updateEmployeeData(Integer empId, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));

        employee.setName(employeeDto.getName());
        employee.setAddress(employeeDto.getAddress());
        employee.setPhone(employeeDto.getPhone());
        employee.setEmail(employeeDto.getEmail());


        Employee updatedEmployee = employeeRepository.save(employee);

        EmployeeDto updatedEmployeeDto = new EmployeeDto();
        updatedEmployeeDto.setName(updatedEmployee.getName());
        updatedEmployeeDto.setAddress(updatedEmployee.getAddress());
        updatedEmployeeDto.setPhone(updatedEmployee.getPhone());
        updatedEmployeeDto.setEmail(updatedEmployee.getEmail());

        return updatedEmployeeDto;
    }
    
}
