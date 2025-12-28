// package com.example.demo.exception;

// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.MethodArgumentNotValidException;
// import org.springframework.web.bind.annotation.ExceptionHandler;
// import org.springframework.web.bind.annotation.RestControllerAdvice;

// import java.util.HashMap;
// import java.util.Map;

// @RestControllerAdvice
// public class GlobalExceptionHandler {

//     @ExceptionHandler(IllegalArgumentException.class)
//     public ResponseEntity<Map<String, String>> handleIllegalArgument(IllegalArgumentException ex) {
//         Map<String, String> error = new HashMap<>();
//         error.put("error", "Bad Request");
//         error.put("message", ex.getMessage());
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//     }

//     @ExceptionHandler(MethodArgumentNotValidException.class)
//     public ResponseEntity<Map<String, String>> handleValidation(MethodArgumentNotValidException ex) {
//         Map<String, String> error = new HashMap<>();
//         error.put("error", "Validation Failed");
//         error.put("message", ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage());
//         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
//     }
// }
