package com.hirequick.model;

import com.hirequick.converter.GenericJsonConverter;
import com.hirequick.enums.CompanySize;
import com.hirequick.enums.CompanyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "companies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(nullable = false, unique = true, length = 200)
    private String slug;

    @Lob
    private String description;

    @Column(length = 500)
    private String tagline;

    private String industry;

    @Enumerated(EnumType.STRING)
    private CompanySize companySize = CompanySize.STARTUP;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType = CompanyType.STARTUP;

    private Integer foundedYear;

    private String website;

    @Column(length = 255)
    private String email;

    @Column(length = 20)
    private String phone;

    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
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

    @Lob
    private String mission;

    @Lob
    private String vision;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> values;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> cultureKeywords;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> benefits;

    @Convert(converter = GenericJsonConverter.class)
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

    @Lob
    private String metaDescription;

    @Convert(converter = GenericJsonConverter.class)
    private List<String> keywords;

    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<RecruiterProfile> recruiters;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<Job> jobs;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = ZonedDateTime.now();
    }

    @Transient
    public String getFullAddress() {
        return String.join(", ",
                List.of(addressLine1, addressLine2, city, state, postalCode, country)
                        .stream()
                        .filter(s -> s != null && !s.isBlank())
                        .toList());
    }

    @Transient
    public String getLocation() {
        return String.join(", ",
                List.of(city, state, country)
                        .stream()
                        .filter(s -> s != null && !s.isBlank())
                        .toList());
    }
}
