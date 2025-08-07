package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "company_reviews")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 200)
    private String title;

    @Lob
    private String content;

    private Double overallRating;

    private Double cultureRating;
    private Double compensationRating;
    private Double workLifeBalanceRating;
    private Double managementRating;
    private Double careerGrowthRating;

    @Column(length = 50)
    private String employmentStatus;

    @Column(length = 200)
    private String jobTitle;

    @Column(length = 50)
    private String employmentDuration;

    @Lob
    private String pros;

    @Lob
    private String cons;

    @Lob
    private String adviceToManagement;

    private Boolean isApproved = false;
    private Boolean isAnonymous = true;

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
