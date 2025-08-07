package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.ZonedDateTime;

@Entity
@Table(name = "application_files")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Relations
    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne
    @JoinColumn(name = "form_field_id")
    private ApplicationFormField formField;

    @Column(length = 500, nullable = false)
    private String filePath;

    @Column(length = 255, nullable = false)
    private String originalFilename;

    private Integer fileSize;  // bytes

    @Column(length = 100, nullable = false)
    private String contentType;

    @Column(length = 50)
    private String fileType;  // resume, cover_letter, etc.

    private Boolean isProcessed = false;

    @Column(length = 20)
    private String processingStatus = "pending";

    @Lob
    private String processingError;

    private ZonedDateTime uploadedAt;
    private ZonedDateTime processedAt;

    @PrePersist
    protected void onCreate() {
        uploadedAt = ZonedDateTime.now();
    }

    @Override
    public String toString() {
        return String.format("<ApplicationFile(id=%d, filename='%s')>", id, originalFilename);
    }

    public String getFileSizeDisplay() {
        double size = fileSize != null ? fileSize : 0;
        String[] units = {"B", "KB", "MB", "GB", "TB"};
        int unitIndex = 0;
        while (size >= 1024 && unitIndex < units.length - 1) {
            size /= 1024;
            unitIndex++;
        }
        return String.format("%.1f %s", size, units[unitIndex]);
    }
}
