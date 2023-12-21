package com.stackroute.emailservice.Service;

import com.stackroute.emailservice.Model.EmailDetails;

public interface EmailService {
    String sendRegistrationMail(String value);

    String sendLoginMail(String al);
    
    String sendUpdateMail(EmailDetails details);
}

