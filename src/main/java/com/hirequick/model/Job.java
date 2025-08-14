package com.hirequick.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import com.hirequick.enums.ExperienceLevel;
import com.hirequick.enums.JobStatus;
import com.hirequick.enums.JobType;
import com.hirequick.enums.RemoteType;
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

    // Relations
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recruiter_id", nullable = false)
    private RecruiterProfile recruiter;

    // Informations de base
    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 200)
    private String slug;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(columnDefinition = "TEXT")
    private String summary;

    @Enumerated(EnumType.STRING)
    private JobType jobType = JobType.FULL_TIME;

    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel = ExperienceLevel.MID;


    @Enumerated(EnumType.STRING)
    private RemoteType remoteType = RemoteType.ONSITE;

    // Localisation
    @Column(length = 200)
    private String location;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    @Column(length = 100)
    private String country;

    private Boolean isRemoteOk = false;

    // Exigences et qualifications (JSON équivalent → List<String>)
    @ElementCollection
    @CollectionTable(name = "job_requirements", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "requirement")
    private List<String> requirements;

    @ElementCollection
    @CollectionTable(name = "preferred_qualifications", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "qualification")
    private List<String> preferredQualifications;

    @ElementCollection
    @CollectionTable(name = "education_requirements", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "education")
    private List<String> educationRequirements;

    // Expérience
    private Integer minExperienceYears = 0;
    private Integer maxExperienceYears;

    // Rémunération
    private Integer salaryMin;
    private Integer salaryMax;

    @Column(length = 3)
    private String salaryCurrency = "USD";

    @Column(length = 20)
    private String salaryType = "annual"; // annual, hourly, project

    private Boolean equityOffered = false;

    // Avantages
    @ElementCollection
    @CollectionTable(name = "job_benefits", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "benefit")
    private List<String> benefits;

    @ElementCollection
    @CollectionTable(name = "job_perks", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "perk")
    private List<String> perks;

    // Paramètres de candidature
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

    // SEO et catégorisation
    @ElementCollection
    @CollectionTable(name = "job_keywords", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "keyword")
    private List<String> keywords;

    @ElementCollection
    @CollectionTable(name = "job_tags", joinColumns = @JoinColumn(name = "job_id"))
    @Column(name = "tag")
    private List<String> tags;

    private String category;
    private String department;

    // Analytique
    private Integer viewCount = 0;
    private Integer applicationCount = 0;

    // Timestamps
    @CreationTimestamp
    @Column(updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    private ZonedDateTime publishedAt;
    private ZonedDateTime expiresAt;

    // Relations
    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ApplicationFormField> formFields;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    @OneToMany(mappedBy = "job", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SavedJob> savedBy;

}
