package com.example.demo.service.impl;

import com.example.demo.exception.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new IllegalArgumentException("email already exists");
        }
        if (user.getPassword() == null || user.getPassword().length() < 8) {
            throw new IllegalArgumentException("Password must be at least 8 characters");
        }
        if (user.getRole() == null) {
            user.setRole("USER");
        }
        if (user.getCreatedAt() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(Long id) {
        return userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}

// package com.example.demo.service.impl;

// import com.example.demo.model.User;
// import com.example.demo.exception.ResourceNotFoundException;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;

// import org.springframework.stereotype.Service;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import com.example.demo.model.Role;

// @Service
// public class UserServiceImpl implements UserService {
 
//     private final PasswordEncoder encoder;
//     private final UserRepository userRepository;
   

//     public UserServiceImpl(UserRepository repo,PasswordEncoder encoder) {
//         this.userRepository = repo;
//         this.encoder = encoder;
//     }

//     @Override
//     public User register(User user) {

//         if (user.getEmail() == null || user.getEmail().isBlank())
//             throw new IllegalArgumentException("Email cannot be empty");

//         if (user.getPassword() == null || user.getPassword().isBlank())
//             throw new IllegalArgumentException("Password cannot be empty");

   
//         user.setPassword(encoder.encode(user.getPassword()));

//        if (user.getRole() == null) {
//     user.setRole("USER");
// }

//         return userRepository.save(user);
//     }

//     @Override
//     public User findByEmail(String email) {
//         return userRepository.findByEmail(email)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }

//     @Override
//     public User findById(Long id) {
//         return userRepository.findById(id)
//                 .orElseThrow(() -> new ResourceNotFoundException("User not found"));
//     }
// }