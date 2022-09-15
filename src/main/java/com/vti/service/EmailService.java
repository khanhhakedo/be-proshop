package com.vti.service;

import com.vti.form.CreatingUserForm;

public interface EmailService {

    // Method
    // To send a simple email
    String sendSimpleMail(CreatingUserForm form);

    // Method
    // To send an email with attachment
    String sendMailWithAttachment(CreatingUserForm form);
}
