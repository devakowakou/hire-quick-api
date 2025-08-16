package com.hirequick.models;

import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "candidate_rankings")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CandidateRanking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    private Integer rank;
    private Double score;

    private Double skillMatchScore = 0.0;
    private Double experienceScore = 0.0;
    private Double educationScore = 0.0;
    private Double locationScore = 0.0;
    private Double availabilityScore = 0.0;

    @ElementCollection
    private List<String> strengths;

    @ElementCollection
    private List<String> weaknesses;

    @ElementCollection
    private List<String> recommendations;

    private Boolean isActive = true;

    @CreationTimestamp
    private ZonedDateTime createdAt;
    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
