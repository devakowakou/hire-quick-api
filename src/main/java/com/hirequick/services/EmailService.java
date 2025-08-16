package com.hirequick.services;

     import lombok.RequiredArgsConstructor;
     import org.springframework.mail.SimpleMailMessage;
     import org.springframework.mail.javamail.JavaMailSender;
     import org.springframework.scheduling.annotation.Async;
     import org.springframework.stereotype.Service;

     @Service
     @RequiredArgsConstructor
     public class EmailService {
         private final JavaMailSender mailSender;

         /**
          * Sends a verification email asynchronously.
          * @param email Recipient's email address.
          * @param token Verification token to include in the email.
          */
         @Async
         public void sendVerificationEmail(String email, String token) {
             SimpleMailMessage message = new SimpleMailMessage();
             message.setTo(email);
             message.setSubject("Verify your email - HireQuick");
             message.setText(
                     "Hello,\n\n" +
                             "Thank you for registering with HireQuick. Please verify your email by clicking the following link:\n\n" +
                             "http://localhost:8080/api/v1/auth/verify-email?token=" + token + "\n\n" +
                             "If you did not request this verification, you can ignore this email.\n\n" +
                             "Best regards,\n" +
                             "The HireQuick Team"
             );
             mailSender.send(message);
         }

         /**
          * Sends a password reset email asynchronously.
          * @param email Recipient's email address.
          * @param token Password reset token to include in the email.
          */
         @Async
         public void sendPasswordResetEmail(String email, String token) {
             SimpleMailMessage message = new SimpleMailMessage();
             message.setTo(email);
             message.setSubject("Reset your password - HireQuick");
             message.setText(
                     "Hello,\n\n" +
                             "You have requested a password reset. Click the following link to set a new password:\n\n" +
                             "http://localhost:8080/api/v1/auth/reset-password?token=" + token + "\n\n" +
                             "If you did not request this reset, please ignore this email.\n\n" +
                             "Best regards,\n" +
                             "The HireQuick Team"
             );
             mailSender.send(message);
         }
     }