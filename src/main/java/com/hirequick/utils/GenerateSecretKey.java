package com.hirequick.utils;

import io.jsonwebtoken.security.Keys;
import javax.crypto.SecretKey;
import java.util.Base64;

public class GenerateSecretKey {
    public static void main(String[] args) {
        SecretKey key = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);

        String encodedKey = Base64.getEncoder().encodeToString(key.getEncoded());

        System.out.println("=== KEY SECRETE GENERATE ===");
        System.out.println("copies key in file application.properties :");
        System.out.println();
        System.out.println("jwt.secret=" + encodedKey);
        System.out.println();
        System.out.println("⚠️  no share key for depot github !");
    }
}
