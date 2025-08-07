package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "company_reviews")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private Float overallRating;

    private Float cultureRating;

    private Float compensationRating;

    private Float workLifeBalanceRating;

    private Float managementRating;

    private Float careerGrowthRating;

    @Column(length = 50)
    private String employmentStatus;

    @Column(length = 200)
    private String jobTitle;

    @Column(length = 50)
    private String employmentDuration;

    @Column(columnDefinition = "TEXT")
    private String pros;

    @Column(columnDefinition = "TEXT")
    private String cons;

    @Column(columnDefinition = "TEXT")
    private String adviceToManagement;

    private Boolean isApproved = false;

    private Boolean isAnonymous = true;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
