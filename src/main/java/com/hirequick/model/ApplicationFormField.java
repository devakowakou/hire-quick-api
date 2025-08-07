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
@Table(name = "application_form_fields")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApplicationFormField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long jobId;

    @Column(length = 50, nullable = false)
    private String fieldType;

    @Column(length = 200, nullable = false)
    private String label;

    @Column(length = 200)
    private String placeholder;

    @Lob
    private String helpText;

    private Boolean isRequired = true;
    private Integer minLength;
    private Integer maxLength;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> options;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> allowedFileTypes;

    private Integer maxFileSizeMb = 10;
    private Integer orderIndex = 0;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }
}
