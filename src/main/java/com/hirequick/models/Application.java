package com.hirequick.models;

import com.hirequick.converter.ObjectListJsonConverter;
import com.hirequick.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;
import java.util.List;


@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relations
    @ManyToOne(optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    @ManyToOne
    @JoinColumn(name = "referrer_id")
    private User referrer;

    // Application status
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ApplicationStatus status = ApplicationStatus.SUBMITTED;

    // Traditional application fields
    @Lob
    private String coverLetter;

    @Column(length = 500)
    private String resumeFile;

    // Dynamic form responses
    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> formResponses;

    // Metadata
    @Column(length = 100)
    private String source;

    // Recruiter notes and feedback
    @Lob
    private String recruiterNotes;

    private Double internalRating;

    @Column(nullable = false)
    private Boolean viewedByRecruiter = false;

    private ZonedDateTime viewedAt;

    // Timestamps
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    private ZonedDateTime submittedAt;

    // Relationships
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicationFile> uploadedFiles;

    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private ParsedResume parsedResume;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interview> interviews;

    @Override
    public String toString() {
        return String.format("<Application(id=%d, job_id=%d, status='%s')>", id, job.getId(), status);
    }

    public String getStatusDisplay() {
        switch (status) {
            case DRAFT: return "Draft";
            case SUBMITTED: return "Submitted";
            case UNDER_REVIEW: return "Under Review";
            case SCREENING: return "Screening";
            case INTERVIEW_SCHEDULED: return "Interview Scheduled";
            case INTERVIEWED: return "Interviewed";
            case OFFER_EXTENDED: return "Offer Extended";
            case OFFER_ACCEPTED: return "Offer Accepted";
            case OFFER_DECLINED: return "Offer Declined";
            case HIRED: return "Hired";
            case REJECTED: return "Rejected";
            case WITHDRAWN: return "Withdrawn";
            default: return status.name();
        }
    }
}
