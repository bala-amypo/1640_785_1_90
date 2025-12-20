package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(
    name = "ticket_categories",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = "categoryName")
    }
)
@Getter
@Setter
@NoArgsConstructor
public class TicketCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String categoryName;

    @Column
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    

    // Parameterized constructor
    public TicketCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

