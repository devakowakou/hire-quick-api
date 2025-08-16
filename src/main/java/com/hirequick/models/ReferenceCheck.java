package com.hirequick.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.hirequick.converter.StringListJsonConverter;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "reference_checks")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ReferenceCheck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verification_result_id", nullable = false)
    private VerificationResult verificationResult;

    // Reference details
    @Column(length = 200, nullable = false)
    private String referenceName;

    @Column(length = 200)
    private String referenceTitle;

    @Column(length = 200)
    private String referenceCompany;

    @Column(length = 255)
    private String referenceEmail;

    @Column(length = 20)
    private String referencePhone;

    // Relationship info
    @Column(length = 50)
    private String relationshipType;

    @Column(length = 50)
    private String relationshipDuration;

    // Reference check results
    private Boolean contactedSuccessfully = false;

    private Boolean willingToProvideReference;

    // Ratings 1-5 scale
    private Double overallRating;

    private Double workQualityRating;

    private Double reliabilityRating;

    private Double teamworkRating;

    private Double communicationRating;

    // Feedback
    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> strengths;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> areasForImprovement;

    private Boolean wouldRehire;

    @Lob
    private String additionalComments;

    // Contact attempts
    private Integer contactAttempts = 0;

    private ZonedDateTime lastContactAttempt;

    // Timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    private ZonedDateTime completedAt;

}
