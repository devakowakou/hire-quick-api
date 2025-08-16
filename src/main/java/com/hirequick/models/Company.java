package com.hirequick.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.OffsetDateTime;
import java.util.List;

import com.hirequick.enums.CompanySize;
import com.hirequick.enums.CompanyType;

@Entity
@Table(name = "companies")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, unique = true, length = 200)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 500)
    private String tagline;

    @Column(length = 100)
    private String industry;

    @Enumerated(EnumType.STRING)
    private CompanySize companySize = CompanySize.STARTUP;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType = CompanyType.STARTUP;

    private Integer foundedYear;

    @Column(length = 500)
    private String website;

    @Column(length = 255)
    private String email;

    @Column(length = 20)
    private String phone;

    @Column(length = 200)
    private String addressLine1;

    @Column(length = 200)
    private String addressLine2;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    @Column(length = 100)
    private String country;

    @Column(length = 20)
    private String postalCode;

    @Column(length = 500)
    private String linkedinUrl;

    @Column(length = 500)
    private String twitterUrl;

    @Column(length = 500)
    private String facebookUrl;

    @Column(length = 500)
    private String instagramUrl;

    @Column(length = 500)
    private String logo;

    @Column(length = 500)
    private String coverImage;

    @Column(columnDefinition = "TEXT")
    private String mission;

    @Column(columnDefinition = "TEXT")
    private String vision;

    @ElementCollection
    private List<String> values;

    @ElementCollection
    private List<String> cultureKeywords;

    @ElementCollection
    private List<String> benefits;

    @ElementCollection
    private List<String> perks;

    private Integer employeeCount;

    private Double annualRevenue;

    @Column(length = 50)
    private String fundingStage;

    private Boolean isVerified = false;

    private Boolean isActive = true;

    private Boolean allowApplications = true;

    @Column(length = 200)
    private String metaTitle;

    @Column(columnDefinition = "TEXT")
    private String metaDescription;

    @ElementCollection
    private List<String> keywords;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;

    @OneToMany(mappedBy = "company")
    private List<RecruiterProfile> recruiters;

    @OneToMany(mappedBy = "company")
    private List<Job> jobs;
}