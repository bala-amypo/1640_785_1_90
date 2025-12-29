
// package com.example.demo.controller;

// import com.example.demo.model.User;
// import com.example.demo.service.UserService;
// import org.springframework.web.bind.annotation.*;

// import java.util.List;

// @RestController
// @RequestMapping("/api/users")
// public class UserController {

//     private final UserService userService;

//     public UserController(UserService userService) {
//         this.userService = userService;
//     }

//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.registerUser(user);
//     }

//     @GetMapping("/{id}")
//     public User getUser(@PathVariable Long id) {
//         return userService.getUser(id);
//     }

//     @GetMapping
//     public List<User> getAllUsers() {
//         return userService.getAllUsers();
//     }
// }

// // package com.example.demo.controller;

// // import com.example.demo.model.User;
// // import com.example.demo.service.UserService;
// // import org.springframework.http.ResponseEntity;
// // import org.springframework.web.bind.annotation.*;

// // import java.util.List;

// // @RestController
// // @RequestMapping("/api/users")
// // public class UserController {

// //     private final UserService userService;

// //     public UserController(UserService userService) {
// //         this.userService = userService;
// //     }

// //     @PostMapping("/register")
// //     public ResponseEntity<User> register(@RequestBody User user) {
// //         return ResponseEntity.ok(userService.registerUser(user));
// //     }

// //     @GetMapping("/all")
// //     public ResponseEntity<List<User>> getAll() {
// //         return ResponseEntity.ok(userService.getAllUsers());
// //     }

// //     @GetMapping("/{id}")
// //     public ResponseEntity<User> getOne(@PathVariable Long id) {
// //         return ResponseEntity.ok(userService.getUser(id));
// //     }

// // }

// package com.example.demo.controller;

// import com.example.demo.dto.AuthRequest;
// import com.example.demo.dto.AuthResponse;
// import com.example.demo.model.User;
// import com.example.demo.security.JwtUtil;
// import com.example.demo.service.UserService;

// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/users")
// public class UserController {

//     private final UserService userService;
//     private final PasswordEncoder passwordEncoder;
//     private final JwtUtil jwtUtil;

//     public UserController(UserService userService,
//                           PasswordEncoder passwordEncoder,
//                           JwtUtil jwtUtil) {
//         this.userService = userService;
//         this.passwordEncoder = passwordEncoder;
//         this.jwtUtil = jwtUtil;
//     }


//     @PostMapping("/register")
//     public User register(@RequestBody User user) {
//         return userService.register(user);
//     }

 

//     @PostMapping("/login")
//     public AuthResponse login(@RequestBody AuthRequest request) {

//         User user = userService.findByEmail(request.getEmail());

//         if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
//             throw new RuntimeException("Invalid credentials");
//         }

//         String token = jwtUtil.generateToken(
//                 user.getId(),
//                 user.getEmail(),
//                 user.getRole()
//         );

//         return new AuthResponse(token, user.getRole());
//     }
// }
package com.example.demo.controller;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Tag(name = "Authentication API")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @Operation(summary = "Login - Get JWT Token", description = "Use email/password from your tests")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            if (request.getEmail() == null || request.getPassword() == null) {
                return ResponseEntity.badRequest().body(new AuthResponse("", "Invalid request"));
            }

            // Use existing test data: a@test.com / password123
            User user = userService.getAllUsers().stream()
                .filter(u -> u.getEmail().equals(request.getEmail()))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
            
            if (!user.getPassword().equals(request.getPassword())) {
                return ResponseEntity.status(401).body(new AuthResponse("", "Wrong password"));
            }
            
            String token = JwtUtil.generateToken(user.getEmail(), user.getId());
            return ResponseEntity.ok(new AuthResponse(token, "Login successful"));
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new AuthResponse("", e.getMessage()));
        }
    }

    @GetMapping("/test")
    @Operation(summary = "Test JWT token")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("✅ JWT works! Token is valid.");
    }
}
