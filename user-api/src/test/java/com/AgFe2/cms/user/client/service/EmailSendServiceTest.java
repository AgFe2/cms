package com.AgFe2.cms.user.client.service;

import com.AgFe2.cms.user.client.service.test.EmailSendService;
import com.AgFe2.cms.user.config.FeignConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmailSendServiceTest {

    @Autowired
    private EmailSendService emailSendService;

    @Test
    public void EmailTest () {
        String response = emailSendService.sendEmail();
        System.out.println(response);
    }

}