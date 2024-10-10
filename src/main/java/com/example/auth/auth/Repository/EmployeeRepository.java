package com.example.auth.auth.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.auth.auth.Entity.Employee;

public interface  EmployeeRepository  extends  JpaRepository<Employee, Integer>{

    Optional<Employee> findByEmail(String email);    
}
