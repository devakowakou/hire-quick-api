package com.hirequick.model;

import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "skill_assessments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SkillAssessment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    private String skillName;
    private String assessmentType;

    private Double score;
    private Double maxScore = 100.0;
    private Boolean passed = false;

    @ElementCollection
    private List<String> questions;

    @ElementCollection
    private List<String> answers;

    private Integer timeTakenMinutes;
    private Boolean isVerified = false;
    private String verifiedBy;

    @CreationTimestamp
    private ZonedDateTime createdAt;
    
    private ZonedDateTime completedAt;
    private ZonedDateTime expiresAt;
}