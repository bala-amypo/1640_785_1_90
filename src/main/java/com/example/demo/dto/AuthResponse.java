// package com.example.demo.dto;

// import lombok.AllArgsConstructor;
// import lombok.Data;

// @Data
// @AllArgsConstructor
// public class AuthResponse {
//     private String token;
// }
package com.example.demo.dto;

public class AuthResponse {
    private String token;
    private String message;

    // Default constructor for JSON deserialization
    public AuthResponse() {}

    // Constructor with parameters
    public AuthResponse(String token, String message) {
        this.token = token;
        this.message = message;
    }

    // Getters and Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
