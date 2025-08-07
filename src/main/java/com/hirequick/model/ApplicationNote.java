package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;


@Entity
@Table(name = "application_notes")

@NoArgsConstructor
@AllArgsConstructor
public class ApplicationNote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "application_id", nullable = false)
    private Application application;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private RecruiterProfile author;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private Boolean isPrivate = true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @Override
    public String toString() {
        return String.format("<ApplicationNote(id=%d, application_id=%d)>", id, application.getId());
    }
}
