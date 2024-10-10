package com.example.auth.auth.services;

import java.time.Instant;
import java.util.UUID;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.auth.auth.Entity.Employee;
import com.example.auth.auth.Entity.RefreshToken;
import com.example.auth.auth.Repository.EmployeeRepository;
import com.example.auth.auth.Repository.RefreshTokenRepository;

@Service
public class RefreshTokenService {

    private final EmployeeRepository employeeRepository;
    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(EmployeeRepository employeeRepository, RefreshTokenRepository refreshTokenRepository) {
        this.employeeRepository = employeeRepository;
        this.refreshTokenRepository = refreshTokenRepository;
    }

    public RefreshToken createRefreshToken(String email){
       Employee employee= employeeRepository.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("Employee not found with email"+email));
        RefreshToken refreshToken = employee.getRefreshToken();
        if(refreshToken==null){

            long refreshTokenDuration = 5*60*60*10000;
            refreshToken = RefreshToken.builder().refreshToken(UUID.randomUUID().toString()).expirationTime(Instant.now().plusMillis(refreshTokenDuration)).employee(employee).build();

            refreshTokenRepository.save(refreshToken);
        }
        return refreshToken;
    }


    public RefreshToken verifyRefreshToken(String refreshToken){
        RefreshToken refToken = refreshTokenRepository.findByRefreshToken(refreshToken).orElseThrow(()->new RuntimeException("Token not found"));
        if(refToken.getExpirationTime().compareTo(Instant.now())<0){
            refreshTokenRepository.delete(refToken);
            throw new RuntimeException("Refresh Token expired");
        }
        return refToken;
    }
    
}
