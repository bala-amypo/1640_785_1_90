// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(name = "tickets")
// @Getter
// @Setter
// @NoArgsConstructor
// public class Ticket {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false)
//     private String subject;

//     @Column(nullable = false, length = 1000)
//     private String description;

//     @Column(nullable = false)
//     private String status = "OPEN";

//     @Column(nullable = false)
//     private LocalDateTime createdAt;

    

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//         if (this.status == null) {
//             this.status = "OPEN";
//         }
//     }
// }
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class Ticket {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;
    @Column(length = 2000)
    private String description;
    private String status = "OPEN";
    private Instant createdAt = Instant.now();

    @ManyToOne
    private User user;

    @ManyToOne
    private TicketCategory category;

    public Ticket() { }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = Instant.now();
        if (status == null) status = "OPEN";
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getStatus() { return status == null ? "OPEN" : status; }
    public void setStatus(String status) { this.status = status; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }

    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public TicketCategory getCategory() { return category; }
    public void setCategory(TicketCategory category) { this.category = category; }
}
