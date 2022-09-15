package com.vti.service;

import com.vti.form.CreatingUserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}") private String sender;

    @Override
    public String sendSimpleMail(CreatingUserForm form) {
        // Try block to check for exceptions
        try {

            // Creating a simple mail message
            SimpleMailMessage mailMessage = new SimpleMailMessage();

            // Setting up necessary details
            mailMessage.setFrom(sender);
            mailMessage.setTo(form.getEmail());
            mailMessage.setText("UserName: "+form.getUserName() +"   ||   "+ "Password: "+form.getUserPassword() );
            mailMessage.setSubject("Simple Email Message");

            // Sending the mail
            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully...";
        }

        // Catch block to handle the exceptions
        catch (Exception e) {
            e.printStackTrace();
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendMailWithAttachment(CreatingUserForm form) {
        // Creating a mime message
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(form.getEmail());
            mimeMessageHelper.setText("Thong tin dang nhap cua ban: "+ "          " + "UserName: "+form.getUserName() +"   ||   "+ "Password: "+form.getUserPassword()+"        " +"CMC Global Xin Cam On!");
            mimeMessageHelper.setSubject(
                    "Simple Email Message");

            // Adding the attachment
//            FileSystemResource file = new FileSystemResource(new File(form.getLink()));
            FileSystemResource file = new FileSystemResource(new File("C:/Users/ADMIN/Documents/file_bai_tap/cmc.jpeg"));

            mimeMessageHelper.addAttachment(file.getFilename(), file);

            // Sending the mail
            javaMailSender.send(mimeMessage);
            return "Mail sent Successfully";
        }

        // Catch block to handle MessagingException
        catch (MessagingException e) {

            // Display message when exception occurred
            return "Error while sending mail!!!";
        }
    }

}
