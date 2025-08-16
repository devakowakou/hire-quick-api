package com.hirequick.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hirequick.converter.ObjectListJsonConverter;
import com.hirequick.converter.StringListJsonConverter;

@Entity
@Table(name = "parsed_resumes")
@Data
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

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> technicalSkills;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> softSkills;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> languages;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> certifications;

    private Double totalExperienceYears = 0.0;

    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> workExperience;

    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> education;

    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> projects;

    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> achievements;

    @Convert(converter = ObjectListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Object> publications;

    @Column(length = 500)
    private String linkedinUrl;

    @Column(length = 500)
    private String githubUrl;

    @Column(length = 500)
    private String portfolioUrl;

    private Double aiScore;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> strengths;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> improvementSuggestions;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> suitableRoles;

    @Column(length = 20)
    private String careerLevel;

    private Double skillMatchScore = 0.0;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> matchedSkills;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> missingSkills;

    @Lob
    private String rawText;

    private Double parsingConfidence;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> parsingErrors;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @Override
    public String toString() {
        return String.format("<ParsedResume(id=%d, application_id=%d)>", id, application.getId());
    }
}
