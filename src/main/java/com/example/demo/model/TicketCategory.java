// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;

// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(
//     name = "ticket_categories",
//     uniqueConstraints = {
//         @UniqueConstraint(columnNames = "categoryName")
//     }
// )
// @Getter
// @Setter
// @NoArgsConstructor
// public class TicketCategory {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(nullable = false, unique = true)
//     private String categoryName;

//     @Column
//     private String description;

//     @Column(nullable = false)
//     private LocalDateTime createdAt;

    
//     public TicketCategory(String categoryName, String description) {
//         this.categoryName = categoryName;
//         this.description = description;
//     }

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class TicketCategory {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String categoryName;
    private String description;
    private Instant createdAt = Instant.now();

    public TicketCategory() { }

    public TicketCategory(String categoryName, String description) {
        this.categoryName = categoryName;
        this.description = description;
    }

    @PrePersist
    public void prePersist() {
        if (createdAt == null) createdAt = Instant.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Instant getCreatedAt() { return createdAt; }
    public void setCreatedAt(Instant createdAt) { this.createdAt = createdAt; }
}
