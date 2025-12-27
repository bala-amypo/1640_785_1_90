
package com.example.demo.model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
public class DuplicateDetectionLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Ticket ticket;

    @ManyToOne
    private Ticket duplicateTicket;

    private double matchScore;
    private Instant detectedAt = Instant.now();

    public DuplicateDetectionLog() { }

    public DuplicateDetectionLog(Ticket ticket, Ticket duplicateTicket, double matchScore) {
        this.ticket = ticket;
        this.duplicateTicket = duplicateTicket;
        this.matchScore = matchScore;
    }

    @PrePersist
    public void prePersist() {
        if (detectedAt == null) detectedAt = Instant.now();
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Ticket getTicket() { return ticket; }
    public void setTicket(Ticket ticket) { this.ticket = ticket; }

    public Ticket getDuplicateTicket() { return duplicateTicket; }
    public void setDuplicateTicket(Ticket duplicateTicket) { this.duplicateTicket = duplicateTicket; }

    public double getMatchScore() { return matchScore; }
    public void setMatchScore(double matchScore) { this.matchScore = matchScore; }

    public Instant getDetectedAt() { return detectedAt; }
    public void setDetectedAt(Instant detectedAt) { this.detectedAt = detectedAt; }
}
