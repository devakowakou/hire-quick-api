package com.hirequick.model;

import com.hirequick.converter.GenericJsonConverter;
import com.hirequick.enums.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "jobs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "recruiter_id", nullable = false)
    private Long recruiterId;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String slug;

    @Lob
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

    @Column(length = 3)
    private String salaryCurrency = "USD";

    @Column(length = 20)
    private String salaryType = "annual";

    private Boolean equityOffered = false;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> benefits;

    @Convert(converter = GenericJsonConverter.class)
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

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }
}
