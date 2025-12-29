package com.example.demo.dto;

import lombok.Data;

// @Data
// public class AuthRequest {
//     private String email;
//     private String password;
// }
// package com.example.demo.dto;

public class AuthRequest {
    private String email;
    private String password;

    // Default constructor for JSON deserialization (Jackson requirement)
    public AuthRequest() {}

    // Constructor with parameters
    public AuthRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
