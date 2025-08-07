package com.hirequick.model;

import com.hirequick.converter.GenericJsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "parsed_resumes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ParsedResume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "application_id", unique = true, nullable = false)
    private Application application;

    @Column(length = 200)
    private String fullName;

    @Column(length = 255)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 200)
    private String location;

    @Lob
    private String summary;

    @Lob
    private String objective;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> technicalSkills;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> softSkills;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> languages;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> certifications;

    private Double totalExperienceYears = 0.0;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> workExperience;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> education;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> projects;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> achievements;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> publications;

    @Column(length = 500)
    private String linkedinUrl;

    @Column(length = 500)
    private String githubUrl;

    @Column(length = 500)
    private String portfolioUrl;

    private Double aiScore;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> strengths;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> improvementSuggestions;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> suitableRoles;

    @Column(length = 20)
    private String careerLevel;

    private Double skillMatchScore = 0.0;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> matchedSkills;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> missingSkills;

    @Lob
    private String rawText;

    private Double parsingConfidence;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> parsingErrors;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

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
        return String.format("<ParsedResume(id=%d, application_id=%d)>", id, application.getId());
    }
}
