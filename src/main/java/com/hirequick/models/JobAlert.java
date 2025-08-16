package com.hirequick.models;

import jakarta.persistence.*;
import lombok.*;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "job_alerts")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 200)
    private String name;

    @ElementCollection
    @CollectionTable(name = "job_alert_keywords", joinColumns = @JoinColumn(name = "job_alert_id"))
    @Column(name = "keyword")
    private List<String> keywords;

    @ElementCollection
    @CollectionTable(name = "job_alert_locations", joinColumns = @JoinColumn(name = "job_alert_id"))
    @Column(name = "location")
    private List<String> locations;

    @ElementCollection
    @CollectionTable(name = "job_alert_job_types", joinColumns = @JoinColumn(name = "job_alert_id"))
    @Column(name = "job_type")
    private List<String> jobTypes;

    @ElementCollection
    @CollectionTable(name = "job_alert_experience_levels", joinColumns = @JoinColumn(name = "job_alert_id"))
    @Column(name = "experience_level")
    private List<String> experienceLevels;

    @ElementCollection
    @CollectionTable(name = "job_alert_remote_types", joinColumns = @JoinColumn(name = "job_alert_id"))
    @Column(name = "remote_type")
    private List<String> remoteTypes;

    private Integer minSalary;
    private Integer maxSalary;

    @Builder.Default
    private Boolean isActive = true;

    @Builder.Default
    @Column(length = 20)
    private String frequency = "daily"; // immediate, daily, weekly

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime updatedAt;

    @Column(columnDefinition = "TIMESTAMP WITH TIME ZONE")
    private ZonedDateTime lastSent;
}