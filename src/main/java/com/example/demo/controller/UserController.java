
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
import com.example.demo.model.Ticket;
import com.example.demo.model.TicketCategory;
import com.example.demo.model.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.TicketCategoryService;
import com.example.demo.service.TicketService;
import com.example.demo.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@Tag(name = "User & Ticket API")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketCategoryService categoryService;

    // ✅ FIXED LOGIN METHOD - COMPLETE & PROPERLY CLOSED
    @PostMapping("/login")
    @Operation(summary = "Login - Get JWT Token", description = "Returns JWT token for Swagger UI")
    @Tag(name = "Authentication")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        try {
            // Validate request
            if (request.getEmail() == null || request.getPassword() == null || 
                request.getEmail().trim().isEmpty() || request.getPassword().trim().isEmpty()) {
                return ResponseEntity.badRequest()
                    .body(new AuthResponse("", "Email and password required"));
            }

            // Find user
            User user = userService.getUserByEmail(request.getEmail())
                .orElseThrow(() -> new ResourceNotFoundException("User not found: " + request.getEmail()));
            
            // Verify password
            if (!user.getPassword().equals(request.getPassword())) {
                return ResponseEntity.status(401)
                    .body(new AuthResponse("", "Invalid password"));
            }
            
            // Generate token
            String token = JwtUtil.generateToken(user.getEmail(), user.getId());
            
            return ResponseEntity.ok(new AuthResponse(token, "Login successful"));
            
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(404).body(new AuthResponse("", e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new AuthResponse("", "Login failed"));
        }
    }

    // ✅ EXAMPLE: Your other methods (keep your existing ones here)
    @GetMapping("/users/{id}")
    @Operation(summary = "Get user by ID")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping("/users")
    @Operation(summary = "Register new user")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/tickets")
    @Operation(summary = "Get all tickets")
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @PostMapping("/tickets")
    @Operation(summary = "Create new ticket")
    public ResponseEntity<Ticket> createTicket(@RequestBody Ticket ticket,
                                               @RequestParam Long userId,
                                               @RequestParam Long categoryId) {
        return ResponseEntity.ok(ticketService.createTicket(userId, categoryId, ticket));
    }

    @GetMapping("/categories")
    @Operation(summary = "Get all categories")
    public ResponseEntity<List<TicketCategory>> getAllCategories() {
        return ResponseEntity.ok(categoryService.getAllCategories());
    }
}
