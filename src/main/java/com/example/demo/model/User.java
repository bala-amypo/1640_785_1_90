// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(
//     name = "users",
//     uniqueConstraints = {
//         @UniqueConstraint(columnNames = "email")
//     }
// )
// @Getter
// @Setter
// @NoArgsConstructor
// public class User {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String fullName;

//     @Column(nullable = false, unique = true)
//     private String email;

//     @Column(nullable = false)
//     private String password;

//     @Column(nullable = false)
//     private String role;

//     @Column(nullable = false)
//     private LocalDateTime createdAt;
    
//     public User(String fullName, String email, String password, String role) {
//         this.fullName = fullName;
//         this.email = email;
//         this.password = password;
//         this.role = (role != null) ? role : "USER";
//     }

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         if (this.role == null) {
//             this.role = "USER";
//         }
//     }
// }

