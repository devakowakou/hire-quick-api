package com.hirequick.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenProvider {

    //secret key
    private final Key key;

    //duration variables for different token types
    private final long emailVerificationTokenExpirationMs = 24 * 60 * 60 * 1000; // 24h
    private final long passwordResetTokenExpirationMs = 60 * 60 * 1000; // 1h

    // Constructor : initialise la clé secrète on application.properties
    public JwtTokenProvider(@Value("${jwt.secret}") String secret) {
        this.key = Keys.hmacShaKeyFor(secret.getBytes());
    }

    // generate token for email verification
    public String generateEmailVerificationToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", "email_verification");
        return buildToken(claims, email, emailVerificationTokenExpirationMs);
    }

    // generate token for password reset
    public String generatePasswordResetToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("type", "password_reset");  // Type de token
        return buildToken(claims, email, passwordResetTokenExpirationMs);
    }

    // construct a JWT token with claims, subject and expiration
    private String buildToken(Map<String, Object> claims, String subject, long expirationMs) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(subject)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    // Validate a JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // extract email from token
    public String getEmailFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // retrieve the type of token (email verification or password reset)
    public String getTokenType(String token) {
        return (String) Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .get("type");
    }
}
