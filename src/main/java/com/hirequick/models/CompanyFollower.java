package com.hirequick.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "company_followers")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class CompanyFollower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Boolean notifyNewJobs = true;

    private Boolean notifyCompanyUpdates = true;

    @CreationTimestamp
    private ZonedDateTime createdAt;
}