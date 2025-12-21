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

    @Column(nullable = false, unique = true,message=("Message must contain category or exists"))
    private String categoryName;

    @Column(message="Message Must contain description")
    private String description;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    
    public TicketCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

