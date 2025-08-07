package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "job_views")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class JobView {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;
    private Long userId;

    @Column(length = 45)
    private String ipAddress;

    @Lob
    private String userAgent;

    @Column(length = 500)
    private String referrer;

    private ZonedDateTime viewedAt;

    @PrePersist
    protected void onCreate() {
        this.viewedAt = ZonedDateTime.now();
    }
}
