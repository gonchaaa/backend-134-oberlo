package com.backend134.oberlo.contrtollers;

import com.backend134.oberlo.entities.Users;
import com.backend134.oberlo.repositories.UserRepository;
import com.backend134.oberlo.services.impl.MailServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mail")
public class MailSenderController {

    private final UserRepository userRepository;
    private final MailServiceImpl mailService;

    @PostMapping()
    public String sendMail(Users users) {
        userRepository.save(users);
        mailService.sendMail(users);
        return "Mail sent successfully";
    }
}
