package com.hirequick.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hirequick.converter.StringListJsonConverter;
import com.hirequick.enums.RemotePreference;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "candidate_profiles")
public class CandidateProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation vers User
    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    // Personal info
    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(length = 200)
    private String location;

    private LocalDate dateOfBirth;

    // Professional info
    @Column(length = 200)
    private String currentTitle;

    @Lob
    private String summary;

    private Integer experienceYears = 0;
    private Integer salaryExpectation;

    @Column(length = 100)
    private String availability; // immediate, 2_weeks, 1_month...

    // Skills and preferences (JSON fields)
    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> skills;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> preferredLocations;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> preferredJobTypes;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private RemotePreference remotePreference = RemotePreference.HYBRID;

    // Social
    @Column(length = 500)
    private String linkedinUrl;

    @Column(length = 500)
    private String githubUrl;

    @Column(length = 500)
    private String portfolioUrl;

    // Files
    @Column(length = 500)
    private String profilePicture;

    @Column(length = 500)
    private String resumeFile;

    // Profile completion
    private boolean profileCompleted = false;
    private Integer completionPercentage = 0;

    // Privacy settings
    @Column(length = 20)
    private String profileVisibility = "public";

    private boolean allowContact = true;

    // Dates
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    // Relationships
    @OneToMany(mappedBy = "candidate")
    private List<Application> applications;

    @OneToMany(mappedBy = "candidate")
    private List<SavedJob> savedJobs;

    // Full name util
    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        return (user != null && user.getEmail() != null)? user.getEmail().split("@")[0]: "Unknown";
    }
}
