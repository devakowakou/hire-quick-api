package com.hirequick.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "saved_jobs")

@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SavedJob {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relations
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "candidate_id", nullable = false)
    private CandidateProfile candidate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    // Notes privées du candidat
    @Column(columnDefinition = "TEXT")
    private String notes;

    // Date d’enregistrement
    @CreationTimestamp
    private ZonedDateTime createdAt;

    @Override
    public String toString() {
        return String.format("SavedJob(candidateId=%d, jobId=%d)", 
                candidate != null ? candidate.getId() : null, 
                job != null ? job.getId() : null);
    }
}
