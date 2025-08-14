package com.hirequick.model;

import com.hirequick.enums.VerificationStatus;
import com.hirequick.converter.StringListJsonConverter;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "background_checks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BackgroundCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign keys
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requested_by_id", nullable = false)
    private RecruiterProfile requestedBy;

    // Check configuration
    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> verificationTypes;

    @Column(length = 20)
    private String priority = "normal";  // low, normal, high, urgent

    // Status and progress
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private VerificationStatus status = VerificationStatus.PENDING;

    private Integer progressPercentage = 0;

    // Results summary
    @Column(length = 20)
    private String overallResult; // clear, flagged, failed

    @Column(length = 20)
    private String riskLevel; // low, medium, high

    // Provider information
    @Column(length = 100)
    private String providerName;

    @Column(length = 100)
    private String providerReference;

    // Cost and billing
    private Double estimatedCost;

    private Double actualCost;

    // Timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    private ZonedDateTime startedAt;

    private ZonedDateTime completedAt;

    private ZonedDateTime expiresAt;

    // Relationships
    @OneToMany(mappedBy = "backgroundCheck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<VerificationResult> verifications;

}
