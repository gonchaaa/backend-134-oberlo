package com.backend134.oberlo.controllers;

import com.backend134.oberlo.entities.Users;
import com.backend134.oberlo.repositories.UserRepository;
import com.backend134.oberlo.services.impl.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailSenderController {

    private final UserRepository userRepository;
    private final MailServiceImpl mailService;

    @PostMapping()
    public String sendMail(@RequestBody Users users) {
        System.out.println("metos ise dusdu");
        System.out.println(users.getEmail());
        Users user = new Users();
        user.setEmail(users.getEmail());
        user.setName(users.getName());
        user.setPhoneNumber(users.getPhoneNumber());
        user.setDescription(users.getDescription());
        userRepository.save(user);
        System.out.println(user.getEmail());
        System.out.println(user.getName());
        mailService.sendMail(user);
        return "Mail sent successfully";
    }
}
