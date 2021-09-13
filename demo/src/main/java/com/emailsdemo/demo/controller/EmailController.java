package com.emailsdemo.demo.controller;

import com.emailsdemo.demo.service.EmailService;
import com.emailsdemo.demo.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {

    @Autowired
    EmailService emailService;

    @Autowired
    User user;

    @RequestMapping("/send-mail/{emailaddress}")
    public String send(@PathVariable("emailaddress") String emailaddress){
        user.setEmailAddress(emailaddress);
        String message=null;
        try {
            emailService.sendMail(user);
            message = "Congratulations! Your message has been sent to "+emailaddress;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return message;
    }




}
