package com.example.auth.auth.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateEmployeeDto {
    
    @NotBlank(message="Please provide name")
    private String name;

    
    @NotBlank(message="Please provide address")
    private String address;

    @NotBlank(message="Please provide phonenumber")
    @Size(min=10,max=10)
    @Pattern(regexp = "^\\d{10}$", message = "Phone number must be 10 digits")
    private String phone;

    @NotBlank(message="Please provide password")
    private String password;

    @NotBlank(message="Please provide email")
    private String email;

}
