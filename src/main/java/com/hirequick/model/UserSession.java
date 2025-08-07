package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Entity
@Table(name = "user_sessions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true, length = 255)
    private String sessionToken;

    @Column(unique = true, length = 255)
    private String refreshToken;

    @Column(length = 45)
    private String ipAddress;

    @Lob
    private String userAgent;

    @Column(length = 50)
    private String deviceType; // mobile, desktop, tablet

    @Column(length = 200)
    private String location;

    private Boolean isActive = true;

    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    private ZonedDateTime lastActivity;

    private ZonedDateTime expiresAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = ZonedDateTime.now();
        this.lastActivity = ZonedDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastActivity = ZonedDateTime.now();
    }
}
