package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "recruiter_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RecruiterProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(length = 100)
    private String firstName;

    @Column(length = 100)
    private String lastName;

    @Column(length = 200)
    private String title;

    @Column(length = 100)
    private String department;

    @Column(length = 20)
    private String phoneExtension;

    @Lob
    private String bio;

    @Column(length = 500)
    private String profilePicture;

    private Boolean canPostJobs = true;
    private Boolean canViewApplications = true;
    private Boolean canScheduleInterviews = true;
    private Boolean canMakeOffers = false;

    private Boolean profileCompleted = false;

    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    private ZonedDateTime updatedAt;

    // Relations
    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<Job> postedJobs;

    @OneToMany(mappedBy = "interviewer", cascade = CascadeType.ALL)
    private List<Interview> conductedInterviews;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

    @Transient
    public String getFullName() {
        if (firstName != null && lastName != null) {
            return firstName + " " + lastName;
        }
        if (user != null && user.getEmail() != null) {
            return user.getEmail().split("@")[0];
        }
        return "Unknown";
    }
}
