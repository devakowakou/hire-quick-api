package com.hirequick.model;

import com.hirequick.converter.GenericJsonConverter;
import com.hirequick.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;

@Entity
@Table(name = "applications")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Foreign keys
    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    @ManyToOne
    @JoinColumn(name = "referrer_id")
    private User referrer;

    // Status
    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ApplicationStatus status = ApplicationStatus.SUBMITTED;

    @Lob
    private String coverLetter;

    @Column(length = 500)
    private String resumeFile;

    // JSON dynamic form responses
    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> formResponses;

    @Column(length = 100)
    private String source;

    @Lob
    private String recruiterNotes;

    private Double internalRating;

    private Boolean viewedByRecruiter = false;

    private ZonedDateTime viewedAt;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime submittedAt;

    // Relationships
    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicationFile> uploadedFiles;

    @OneToOne(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private ParsedResume parsedResume;

    @OneToMany(mappedBy = "application", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Interview> interviews;

    @PrePersist
    protected void onCreate() {
        createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = ZonedDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("<Application(id=%d, job_id=%d, status='%s')>", id, job.getId(), status);
    }

    public String getStatusDisplay() {
        switch (status) {
            case DRAFT: return ApplicationStatus.DRAFT.name();
            case SUBMITTED: return ApplicationStatus.SUBMITTED.name();
            case UNDER_REVIEW: return ApplicationStatus.UNDER_REVIEW.name();
            case SCREENING: return ApplicationStatus.SCREENING.name();
            case INTERVIEW_SCHEDULED: return ApplicationStatus.INTERVIEW_SCHEDULED.name();
            case INTERVIEWED: return ApplicationStatus.INTERVIEWED.name();
            case OFFER_EXTENDED: return ApplicationStatus.OFFER_EXTENDED.name();
            case OFFER_ACCEPTED: return ApplicationStatus.OFFER_ACCEPTED.name();
            case OFFER_DECLINED: return ApplicationStatus.OFFER_DECLINED.name();
            case HIRED: return ApplicationStatus.HIRED.name();
            case REJECTED: return ApplicationStatus.REJECTED.name();
            case WITHDRAWN: return ApplicationStatus.WITHDRAWN.name();
            default: return status.name();
        }
    }
}
