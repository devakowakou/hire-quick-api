package com.hirequick.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.time.ZonedDateTime;

@Entity
@Table(name = "user_sessions")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false, unique = true, length = 255)
    private String sessionToken;

    @Column(unique = true, length = 255, nullable = true)
    private String refreshToken;

    @Column(length = 45, nullable = true)
    private String ipAddress;

    @Lob
    @Column(nullable = true)
    private String userAgent;

    @Column(length = 50, nullable = true)
    private String deviceType; // mobile, desktop, tablet

    @Column(length = 200, nullable = true)
    private String location;

    @Column(nullable = false)
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime lastActivity;

    @Column(nullable = true)
    private ZonedDateTime expiresAt;
}
