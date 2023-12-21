package com.stackroute.emailservice.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stackroute.emailservice.Model.TeacherProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.io.File;

import com.stackroute.emailservice.Model.EmailDetails;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Configuration
public class EmailServiceImpl implements  EmailService{



    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private  String sender;

    @KafkaListener(topics ="userRegistration", groupId = "group-1")
    public void getMailId(@RequestBody String item)throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());


        TeacherProfile product1 = objectMapper.readValue(item, TeacherProfile.class);

        sendRegistrationMail(product1.getMailId());
        sendLoginMail(product1.getMailId());

    }

    @KafkaListener(topics ="teacherRegistration", groupId = "group-1")
    public void getTeacherMailId(@RequestBody String item)throws JsonMappingException, JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        objectMapper.registerModule(new JavaTimeModule());


        TeacherProfile product1 = objectMapper.readValue(item, TeacherProfile.class);

        sendRegistrationMail(product1.getMailId());
        sendLoginMail(product1.getMailId());

    }




    @Override
    public String sendRegistrationMail(String value) {
        System.out.println(value);
        try{
            SimpleMailMessage mailMessage = new SimpleMailMessage();
            mailMessage.setFrom(sender);
            mailMessage.setTo(value);
            mailMessage.setText("Hello\nThank you for choosing Maestromatch.\nWith Regards\nTeam Maestromatch");
            mailMessage.setSubject("WELCOME TO MAESTROMATCH");

            javaMailSender.send(mailMessage);
            return "Mail Sent Successfully";
        }
        catch (Exception exception){
            return "Error while Sending Mail";
        }
    }

    @Override
    public String sendLoginMail(String value) {
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(value);
            mimeMessageHelper.setText("Hello\nYou are successfully login to Maestromatch.");
            mimeMessageHelper.setSubject( "LOGIN SUCCESSFULLY");

            // Adding the attachment
         /*   FileSystemResource file
                    = new FileSystemResource(
                    new File());

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);
**/
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
    
    @Override
    public String sendUpdateMail(EmailDetails details) {
        MimeMessage mimeMessage
                = javaMailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper;

        try {

            // Setting multipart as true for attachments to
            // be send
            mimeMessageHelper
                    = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setFrom(sender);
            mimeMessageHelper.setTo(details.getRecipient());
            mimeMessageHelper.setText("Hii\nSomething new is there for You");
            mimeMessageHelper.setSubject(
                    "UPDATE REMINDER");

//             Adding the attachment
            FileSystemResource file
                    = new FileSystemResource(
                    new File(details.getAttachment()));

            mimeMessageHelper.addAttachment(
                    file.getFilename(), file);

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
