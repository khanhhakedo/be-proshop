package com.vti.controller;

import com.vti.form.CreatingUserForm;
import com.vti.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    private EmailService emailService;

    // Sending a simple Email
    @PostMapping("/sendMail")
    public String sendMail(@RequestBody CreatingUserForm form) {
        String status = emailService.sendSimpleMail(form);
        return status;
    }

    // Sending email with attachment
    @PostMapping("/sendMailWithAttachment")
    public String sendMailWithAttachment(@RequestBody CreatingUserForm form) {
        String status = emailService.sendMailWithAttachment(form);
        return status;
    }
}
