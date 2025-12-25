// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;

// @Entity
// @Table(name = "duplicate_detection_logs")
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
// public class DuplicateDetectionLog {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;
    

//     @Column(name = "match_score", nullable = false)
//     private Double matchScore; 

//     @Column(name = "detected_at", nullable = false, updatable = false)
//     private LocalDateTime detectedAt;

//     @PrePersist
//     protected void onDetect() {
//         this.detectedAt = LocalDateTime.now();
//     }
// }

package com.example.demo.model;

import java.time.LocalDateTime;

public class DuplicateDetectionLog {
    private Ticket ticket;
    private Ticket matchedTicket;
    private double matchScore;
    private LocalDateTime detectedAt = LocalDateTime.now();

    public DuplicateDetectionLog() {}

    public DuplicateDetectionLog(Ticket ticket, Ticket matchedTicket, double matchScore) {
        this.ticket = ticket;
        this.matchedTicket = matchedTicket;
        this.matchScore = matchScore;
    }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public Ticket getMatchedTicket() { return matchedTicket; }
    public void setMatchedTicket(Ticket matchedTicket) { this.matchedTicket = matchedTicket; }

    public double getMatchScore() { return matchScore; }
    public void setMatchScore(double matchScore) { this.matchScore = matchScore; }

    public LocalDateTime getDetectedAt() { return detectedAt; }
}
