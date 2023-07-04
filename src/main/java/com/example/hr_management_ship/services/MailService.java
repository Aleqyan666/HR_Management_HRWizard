package com.example.hr_management_ship.services;

import com.example.hr_management_ship.validation.Validator;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    private void sendEmailWithStatistics(String toEmail) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("haykalekyan@gmail.com");
        mimeMessageHelper.setTo(toEmail);
        mimeMessageHelper.setText("Here in the file below you can see the performances of our employees");
        mimeMessageHelper.setSubject("Employee performance Monitoring");

        FileSystemResource fileSystemResource
                = new FileSystemResource(
                new File("C://Users//user//Documents//UserPerformanceTracker.pbix"));
        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(mimeMessage);

        System.out.println("Mail with attachment sent successfully");
    }

    public void monitorEmployeePerformance(String toEmail) throws MessagingException {
       log.info("Monitoring employee performance. Sending email to: {}", toEmail);

        try {
            Validator.checkEmail(toEmail);
            sendEmailWithStatistics(toEmail);
            log.info("Email sent successfully to: {}", toEmail);
        } catch (MessagingException e) {
            log.error("Failed to send email to: {}", toEmail, e);
            throw e;
        }
    }
}

