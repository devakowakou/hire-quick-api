package com.hirequick.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "talent_pool_entries")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TalentPoolEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "candidate_id", nullable = false, unique = true)
    private CandidateProfile candidate;

    private Boolean isActive = true;
    private Boolean isAvailable = true;
    private ZonedDateTime availabilityDate;

    private String profileVisibility = "public";
    private Boolean allowContact = true;

    @ElementCollection
    private List<String> preferredRoles;

    @ElementCollection
    private List<String> preferredLocations;

    @ElementCollection
    private List<String> preferredCompanies;

    private Integer preferredSalaryMin;
    private Integer preferredSalaryMax;

    private Boolean autoMatchingEnabled = true;
    private Double matchScoreThreshold = 0.5;

    private Integer profileViews = 0;
    private Integer contactRequests = 0;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime lastActive;

    @OneToMany(mappedBy = "talentEntry")
    private List<JobMatch> matches;
}
