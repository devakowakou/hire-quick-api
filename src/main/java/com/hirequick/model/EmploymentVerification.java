package com.hirequick.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.hirequick.converter.GenericJsonConverter;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "employment_verifications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmploymentVerification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "verification_result_id", nullable = false)
    private VerificationResult verificationResult;

    // Employment details
    @Column(length = 200, nullable = false)
    private String companyName;

    @Column(length = 200, nullable = false)
    private String jobTitle;

    private ZonedDateTime startDate;

    private ZonedDateTime endDate;

    private Double salary;

    // Verification results
    private Boolean companyVerified;

    private Boolean titleVerified;

    private Boolean datesVerified;

    private Boolean salaryVerified;

    // Contact information
    @Column(length = 200)
    private String hrContactName;

    @Column(length = 255)
    private String hrContactEmail;

    @Column(length = 20)
    private String hrContactPhone;

    // Notes
    @Lob
    private String verificationNotes;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> discrepancies;

    // Timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

}
