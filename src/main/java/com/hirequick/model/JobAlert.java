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
@Table(name = "job_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobAlert {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;

    @Column(length = 200, nullable = false)
    private String name;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> keywords;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> locations;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> jobTypes;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> experienceLevels;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> remoteTypes;

    private Integer minSalary;
    private Integer maxSalary;

    private Boolean isActive = true;

    @Column(length = 20)
    private String frequency = "daily";

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime lastSent;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }
}
