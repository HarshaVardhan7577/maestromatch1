package com.stackroute.emailservice.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.emailservice.Model.EmailDetails;
import com.stackroute.emailservice.Service.EmailService;

@RestController
@RequestMapping("/notifications")
public class EmailController {

    @Autowired
    private EmailService service;


//    @PostMapping("/Registration")
//    public String registrationMail(@RequestBody EmailDetails details){
//
//        String status = service.sendRegistrationMail(details);
//        return status;
//    }

//    @PostMapping("/Login")
//    public String loginMail(
//            @RequestBody EmailDetails details)
//    {
//        String status
//                = service.sendLoginMail(details);
//
//        return status;
//    }
    
    @PostMapping("/Update")
    public String updateMail(@RequestBody EmailDetails details) {
    	
    	String status = service.sendUpdateMail(details);
    	return status;
    }
}
