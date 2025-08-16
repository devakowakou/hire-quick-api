package com.hirequick.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.ZonedDateTime;
import java.util.List;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
@Entity
@Table(name = "recruiter_profiles")
@Data
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

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "recruiter", cascade = CascadeType.ALL)
    private List<Job> postedJobs;

    @OneToMany(mappedBy = "interviewer", cascade = CascadeType.ALL)
    private List<Interview> conductedInterviews;

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
