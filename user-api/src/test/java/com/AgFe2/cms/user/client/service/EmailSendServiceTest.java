package com.AgFe2.cms.user.client.service;

import com.AgFe2.cms.user.client.MailgunClient;
import com.AgFe2.cms.user.client.mailgun.SendMailForm;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailSendServiceTest {

    @Autowired
    private MailgunClient mailgunClinet;

    @Test
    public void EmailTest () {
        // need test code
        SendMailForm form = SendMailForm.builder()
                .from("frog5667@gmail.com")
                .to("duug@naver.com")
                .subject("Test email from AgFe2")
                .text("my text")
                .build();

        mailgunClinet.sendEmail(form);
//        String response = mailgunClinet.sendEmail();
//        System.out.println(response);

    }
}