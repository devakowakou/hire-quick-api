package com.hirequick.models;

import java.time.ZonedDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hirequick.enums.MatchStatus;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "job_matches")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class JobMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "talent_entry_id", nullable = false)
    private TalentPoolEntry talentEntry;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;
    
    private Double overallScore;
    private Double skillScore = 0.0;
    private Double experienceScore = 0.0;
    private Double locationScore = 0.0;
    private Double salaryScore = 0.0;
    private Double cultureScore = 0.0;

    @ElementCollection
    private List<String> matchedSkills;

    @ElementCollection
    private List<String> missingSkills;

    @ElementCollection
    private List<String> skillGaps;

    @ElementCollection
    private List<String> matchReasons;

    @ElementCollection
    private List<String> concerns;
    @Enumerated(EnumType.STRING)
    private MatchStatus status = MatchStatus.PENDING;
    private Boolean viewedByCandidate = false;
    private Boolean viewedByRecruiter = false;

    private String candidateFeedback;
    private String recruiterFeedback;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    private ZonedDateTime expiresAt;
    private ZonedDateTime viewedAt;
}