package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "duplicate_rules", uniqueConstraints = {
        @UniqueConstraint(columnNames = "rule_name")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DuplicateRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_name", nullable = false, unique = true)
    private String ruleName;

    @Column(name = "match_type", nullable = false)
    private String matchType;
    

    @Column(nullable = false)
    private Double threshold; 

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    public DuplicateRule(String ruleName, String matchType, Double threshold) {
        this.ruleName = ruleName;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}

