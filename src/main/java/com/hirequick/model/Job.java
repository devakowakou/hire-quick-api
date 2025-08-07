package com.hirequick.model;

import com.hirequick.converter.GenericJsonConverter;
import com.hirequick.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruiter_id", nullable = false)
    private RecruiterProfile recruiter;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String slug;

    @Lob
    @Column(nullable = false)
    private String description;

    @Lob
    private String summary;

    @Enumerated(EnumType.STRING)
    private JobType jobType = JobType.FULL_TIME;

    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel = ExperienceLevel.MID;

    @Enumerated(EnumType.STRING)
    private RemoteType remoteType = RemoteType.ONSITE;

    private String location;
    private String city;
    private String state;
    private String country;
    private Boolean isRemoteOk = false;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> requirements;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> preferredQualifications;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> educationRequirements;

    private Integer minExperienceYears = 0;
    private Integer maxExperienceYears;

    private Integer salaryMin;
    private Integer salaryMax;
    private String salaryCurrency = "USD";
    private String salaryType = "annual";
    private Boolean equityOffered = false;

    @Convert(converter = com.hirequick.converter.GenericJsonConverter.class)
    private List<String> benefits;

    @Convert(converter = com.hirequick.converter.GenericJsonConverter.class)
    private List<String> perks;

    private ZonedDateTime applicationDeadline;
    private Integer maxApplications;
    private Boolean autoRejectAfterDeadline = false;

    private Boolean hasCustomForm = false;
    private Boolean requireCoverLetter = false;
    private Boolean requireResume = true;

    @Enumerated(EnumType.STRING)
    private JobStatus status = JobStatus.DRAFT;

    private Boolean isFeatured = false;
    private Boolean isUrgent = false;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> keywords;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> tags;

    private String category;
    private String department;

    private Integer viewCount = 0;
    private Integer applicationCount = 0;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime publishedAt;
    private ZonedDateTime expiresAt;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicationFormField> formFields;

    @OneToMany(mappedBy = "job")
    private List<Application> applications;

    @OneToMany(mappedBy = "job")
    private List<SavedJob> savedBy;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

    @Transient
    public String getSalaryRange() {
        if (salaryMin != null && salaryMax != null) {
            return "$" + salaryMin + " - $" + salaryMax;
        } else if (salaryMin != null) {
            return "$" + salaryMin + "+";
        }
        return null;
    }

    @Transient
    public boolean isExpired() {
        return expiresAt != null && expiresAt.isBefore(ZonedDateTime.now());
    }
}
