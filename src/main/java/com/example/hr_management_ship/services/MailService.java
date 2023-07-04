package com.example.hr_management_ship.services;

import com.example.hr_management_ship.models.CompanyModel;
import com.example.hr_management_ship.models.UserModel;
import com.example.hr_management_ship.repositorys.CompanyRepository;
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
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender javaMailSender;
    private final CompanyRepository companyRepository;

    public void sendEmail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }

    private void sendEmailWithStatistics(
            String toEmail) throws MessagingException {

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

    public void notifyBasedOnRating(long id) {
        final int UPPER_LIMIT = 8;
        final int LOWER_LIMIT = 4;
        CompanyModel company = companyRepository.getCompanyModelById(id);
        List<UserModel> users =  company.getUsers();

        for (UserModel user : users) {
            double rating = (double) user.getTotalCoins() / user.getTotalTransactions();

            if (rating > UPPER_LIMIT) {
                log.info("Sending email to user {} - Performance enhanced!!!", user.getEmail());
                Validator.checkEmail(user.getEmail());
                sendEmail(user.getEmail(),
                        "Performance enhanced!!!",
                        "We would like to inform you about bonuses we consider based on your performance.");
            } else if (rating < LOWER_LIMIT) {
                log.info("Sending email to user {} - Performance diminished!!!", user.getEmail());
                Validator.checkEmail(user.getEmail());
                sendEmail(user.getEmail(),
                        "Performance diminished!!!",
                        "We would like to inform you about a special meeting to have with you in order " +
                                "to thoroughly discuss issues regarding your performance.");
            }
        }
    }
}

