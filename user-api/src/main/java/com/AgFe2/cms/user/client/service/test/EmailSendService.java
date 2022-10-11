package com.AgFe2.cms.user.client.service.test;

import com.AgFe2.cms.user.client.MailgunClient;
import com.AgFe2.cms.user.client.mailgun.SendMailForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailSendService {
    private final MailgunClient mailgunClient;

    public String sendEmail() {

        SendMailForm form = SendMailForm.builder()
                .from("frog5667@gmail.com")
                .to("duug@naver.com")
                .subject("Test email from AgFe2")
                .text("my text")
                .build();

        return mailgunClient.sendEmail(form).getBody();
    }

}
