package com.hirequick.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "job_views")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = true) 
    private User user;

    // Métadonnées de vue
    @Column(length = 45)
    private String ipAddress;

    @Column(columnDefinition = "TEXT")
    private String userAgent;

    @Column(length = 500)
    private String referrer;

    // Timestamp
    @CreationTimestamp
    private ZonedDateTime viewedAt;

    @Override
    public String toString() {
        return String.format("JobView(jobId=%d, userId=%s)",
                job != null ? job.getId() : null,
                user != null ? user.getId() : "anonymous");
    }
}
