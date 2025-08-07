package com.hirequick.model;

import com.hirequick.enums.InterviewStatus;
import com.hirequick.enums.InterviewType;
import com.hirequick.converter.GenericJsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "interviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne
    @JoinColumn(name = "interviewer_id", nullable = false)
    private RecruiterProfile interviewer;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private InterviewType interviewType = InterviewType.VIDEO;

    @Column(length = 200)
    private String title;

    @Lob
    private String description;

    @Column(nullable = false)
    private ZonedDateTime scheduledAt;

    private Integer durationMinutes = 60;

    @Column(length = 50)
    private String timezone = "UTC";

    @Column(length = 500)
    private String location;

    @Column(length = 500)
    private String meetingLink;

    @Column(length = 100)
    private String meetingId;

    @Column(length = 100)
    private String meetingPassword;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private InterviewStatus status = InterviewStatus.SCHEDULED;

    @Lob
    private String feedback;

    private Double rating;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> questions;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> responses;

    @Convert(converter = GenericJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Long> additionalInterviewers;

    private Boolean reminderSentCandidate = false;
    private Boolean reminderSentInterviewer = false;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
    private ZonedDateTime completedAt;

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
        return String.format("<Interview(id=%d, application_id=%d, status='%s')>", id, application.getId(), status);
    }
}
