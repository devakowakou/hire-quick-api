package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "application_files")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relation vers Application
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    // Relation optionnelle vers le champ du formulaire
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "form_field_id")
    private ApplicationFormField formField;

    // File information
    @Column(name = "file_path", length = 500, nullable = false)
    private String filePath;

    @Column(name = "original_filename", length = 255, nullable = false)
    private String originalFilename;

    @Column(name = "file_size", nullable = false)
    private Long fileSize; // en bytes

    @Column(name = "content_type", length = 100, nullable = false)
    private String contentType;

    @Column(name = "file_type", length = 50)
    private String fileType; // resume, cover_letter, portfolio, etc.

    // File processing status
    @Column(name = "is_processed", nullable = false)
    private Boolean isProcessed = false;

    @Column(name = "processing_status", length = 20)
    private String processingStatus = "pending"; // pending, processing, completed, failed

    @Column(name = "processing_error", columnDefinition = "TEXT")
    private String processingError;

    // Timestamps
    @CreationTimestamp
    @Column(name = "uploaded_at", updatable = false)
    private ZonedDateTime uploadedAt;

    @Column(name = "processed_at")
    private ZonedDateTime processedAt;

    @Override
    public String toString() {
        return String.format("<ApplicationFile(id=%d, filename='%s')>", id, originalFilename);
    }
}
