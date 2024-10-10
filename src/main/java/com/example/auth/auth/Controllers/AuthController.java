package com.example.auth.auth.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.auth.auth.Dto.CreateEmployeeDto;
import com.example.auth.auth.Dto.LoginDto;
import com.example.auth.auth.services.AuthService;

import jakarta.validation.Valid;



@RestController
@RequestMapping("/auth")
public class AuthController {
    
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto loginRequest) {
        try {
            authService.login(loginRequest);
            return ResponseEntity.ok("Login successful");  
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage()); 
        }
    }
    

    @PostMapping("/register")
    public ResponseEntity<CreateEmployeeDto> register( @Valid @RequestBody CreateEmployeeDto entity) {
        return ResponseEntity.ok(authService.registerEmployee(entity));
    }
    
}
