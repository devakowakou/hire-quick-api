package com.hirequick.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.hirequick.converter.ObjectListJsonConverter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "education_verifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EducationVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verification_result_id", nullable = false)
    private VerificationResult verificationResult;

    // Education details
    @Column(length = 200, nullable = false)
    private String institutionName;

    @Column(length = 100, nullable = false)
    private String degreeType;

    @Column(length = 200, nullable = false)
    private String degreeName;

    @Column(length = 200)
    private String fieldOfStudy;

    private ZonedDateTime graduationDate;

    private Double gpa;

    // Verification results
    private Boolean institutionVerified;

    private Boolean degreeVerified;

    private Boolean datesVerified;

    private Boolean gpaVerified;

    // Contact info
    @Column(length = 200)
    private String registrarContact;

    @Column(length = 255)
    private String registrarEmail;

    @Column(length = 20)
    private String registrarPhone;

    // Notes
    @Lob
    private String verificationNotes;

    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> discrepancies;

    // Timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
