package com.hirequick.model;

import com.hirequick.enums.VerificationStatus;
import com.hirequick.converter.GenericJsonConverter;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "verification_results")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class VerificationResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign key
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "background_check_id", nullable = false)
    private BackgroundCheck backgroundCheck;

    // Verification details
    @Column(length = 30, nullable = false)
    private String verificationType;

    @Column(length = 200, nullable = false)
    private String verificationName;

    // Status and results
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private VerificationStatus status = VerificationStatus.PENDING;

    @Column(length = 20)
    private String result;  // clear, flagged, failed, unable_to_verify

    // Verification data
    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> dataVerified;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> findings;

    // Details and notes
    @Lob
    private String details;

    @Lob
    private String notes;

    // Provider information
    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> providerResponse;

    @Column(length = 100)
    private String providerReference;

    // Timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    private ZonedDateTime completedAt;

}
