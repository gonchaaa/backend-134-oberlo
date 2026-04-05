package com.backend134.oberlo.services.impl;

import com.backend134.oberlo.entities.Users;
import com.backend134.oberlo.services.IMailService;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailServiceImpl implements IMailService {

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMail(Users users) {
        String toUser = users.getEmail();
        String subject = "Hörmətli" + users.getName();
        String body = "Sizin müraciətiniz uğurla qeydə alındı. Tezliklə sizin qeyd etdiyiniz.\n\n" + users.getPhoneNumber() + "əlaqə nömrəsi ilə əməkdaşlarımız tərəfindən əlaqə saxlanacaq." +
                "Əlavə məlumat üçün bizimlə əlaqə saxlaya bilərsiniz.\n\n" +
                "Əlaqə nömrəsi: +994 777 \n" +
                "Hörmətlə,\n" +
                "Backend134 komandası";

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(toUser);
        mailMessage.setSubject(subject);
        mailMessage.setText(body);
        javaMailSender.send(mailMessage);

    }
}
