package com.hirequick.model;

import com.hirequick.enums.InterviewStatus;
import com.hirequick.enums.InterviewType;
import com.hirequick.converter.StringListJsonConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "interviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Interview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne(optional = false)
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

    @Column(nullable = false)
    private Integer durationMinutes = 60;

    @Column(length = 50, nullable = false)
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
    @Column(length = 20, nullable = false)
    private InterviewStatus status = InterviewStatus.SCHEDULED;

    @Lob
    private String feedback;

    private Double rating;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> questions;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<String> responses;

    @Convert(converter = StringListJsonConverter.class)
    @Column(columnDefinition = "jsonb")
    private List<Long> additionalInterviewers;

    @Column(nullable = false)
    private Boolean reminderSentCandidate = false;

    @Column(nullable = false)
    private Boolean reminderSentInterviewer = false;

    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Column(nullable = true)
    private ZonedDateTime completedAt;

    @Override
    public String toString() {
        return String.format("<Interview(id=%d, application_id=%d, status='%s')>", id, application.getId(), status);
    }
}
