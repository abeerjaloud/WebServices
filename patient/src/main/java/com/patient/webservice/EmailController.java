package com.patient.webservice;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmailController {
   @RequestMapping(value = "/sendemail")
   public String sendEmail() {
      return "Email sent successfully";
   }   
}