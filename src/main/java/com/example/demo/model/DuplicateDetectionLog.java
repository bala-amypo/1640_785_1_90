package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "duplicate_detection_logs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DuplicateDetectionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Base ticket for which duplicates are being detected
   
    

    @Column(name = "match_score", nullable = false)
    private Double matchScore; // must be >= 0

    @Column(name = "detected_at", nullable = false, updatable = false)
    private LocalDateTime detectedAt;

   

    // Automatically set detectedAt on first persist
    @PrePersist
    protected void onDetect() {
        this.detectedAt = LocalDateTime.now();
    }
}

