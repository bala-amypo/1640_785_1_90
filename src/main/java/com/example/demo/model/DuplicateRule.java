// package com.example.demo.model;

// import jakarta.persistence.*;
// import lombok.*;

// import java.time.LocalDateTime;
// import java.util.List;

// @Entity
// @Table(name = "duplicate_rules", uniqueConstraints = {
//         @UniqueConstraint(columnNames = "rule_name")
// })
// @Getter
// @Setter
// @NoArgsConstructor
// @AllArgsConstructor
// @ToString
// public class DuplicateRule {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     @Column(name = "rule_name", nullable = false, unique = true)
//     private String ruleName;

//     @Column(name = "match_type", nullable = false)
//     private String matchType;
    

//     @Column(nullable = false)
//     private Double threshold; 

//     @Column(name = "created_at", nullable = false, updatable = false)
//     private LocalDateTime createdAt;

//     public DuplicateRule(String ruleName, String matchType, Double threshold) {
//         this.ruleName = ruleName;
//         this.matchType = matchType;
//         this.threshold = threshold;
//     }

//     @PrePersist
//     protected void onCreate() {
//         this.createdAt = LocalDateTime.now();
//     }
// }

package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class DuplicateRule {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleName;
    private String matchType;
    private double threshold;

    public DuplicateRule() { }

    public DuplicateRule(String ruleName, String matchType, double threshold) {
        this.ruleName = ruleName;
        this.matchType = matchType;
        this.threshold = threshold;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }

    public String getMatchType() { return matchType; }
    public void setMatchType(String matchType) { this.matchType = matchType; }

    public double getThreshold() { return threshold; }
    public void setThreshold(double threshold) { this.threshold = threshold; }
}
