package com.hirequick.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "application_form_fields")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFormField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Chaque champ appartient à un job
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    // Configuration du champ
    @Column(name = "field_type", length = 50, nullable = false)
    private String fieldType;

    @Column(nullable = false, length = 200)
    private String label;

    @Column(length = 200)
    private String placeholder;

    @Column(columnDefinition = "TEXT")
    private String helpText;

    // Validation
    @Column(name = "is_required")
    private Boolean isRequired = true;

    private Integer minLength;

    private Integer maxLength;

    // Options pour select, radio, checkbox
    @ElementCollection
    @CollectionTable(name = "application_form_field_options", joinColumns = @JoinColumn(name = "form_field_id"))
    @Column(name = "option_value")
    private List<String> options;

    // Paramètres pour upload de fichier
    @ElementCollection
    @CollectionTable(name = "application_form_field_file_types", joinColumns = @JoinColumn(name = "form_field_id"))
    @Column(name = "file_type")
    private List<String> allowedFileTypes;

    @Column(name = "max_file_size_mb")
    private Integer maxFileSizeMb = 10;

    // Ordre du champ
    @Column(name = "field_order")
    private Integer order = 0;

    // Timestamps
    @CreationTimestamp
    @Column(name = "created_at", updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private ZonedDateTime updatedAt;

    @Override
    public String toString() {
        return "ApplicationFormField{" +
                "id=" + id +
                ", label='" + label + '\'' +
                ", jobId=" + (job != null ? job.getId() : null) +
                '}';
    }
}
