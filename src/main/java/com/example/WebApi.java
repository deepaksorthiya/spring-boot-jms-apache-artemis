package com.example;

import org.springframework.http.ResponseEntity;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebApi {

    private JmsTemplate jmsTemplate;

    public WebApi(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @GetMapping
    public ResponseEntity<Void> sendEmail() {
        // Send a message with a POJO - the template reuse the message converter
        System.out.println("Sending an email message.");
        jmsTemplate.convertAndSend("mailbox", new Email("info@example.com", "Hello"));
        return ResponseEntity.ok().build();
    }
}
