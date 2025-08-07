package com.hirequick.model;

import com.hirequick.converter.GenericJsonConverter;
import com.hirequick.enums.ApplicationStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    @ManyToOne
    @JoinColumn(name = "referrer_id")
    private User referrer;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, nullable = false)
    private ApplicationStatus status = ApplicationStatus.SUBMITTED;

    @Lob
    private String coverLetter;

    @Column(length = 500)
    private String resumeFile;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private Map<String, Object> formResponses;

    @Column(length = 100)
    private String source;

    @Lob
    private String recruiterNotes;

    private Double internalRating;

    @Column(nullable = false)
    private Boolean viewedByRecruiter = false;

    private ZonedDateTime viewedAt;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    private ZonedDateTime submittedAt;

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
        // Option simple
        return status.name();
    }
}
