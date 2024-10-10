package com.example.auth.auth.Dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginDto {

    @NotBlank(message="Please provide email")
    private String email;

    @NotBlank(message="Please provide password")
    private String password;
}
