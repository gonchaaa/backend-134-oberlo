package com.backend134.oberlo.controllers;

import com.backend134.oberlo.DTOs.request.UserLoginDTO;
import com.backend134.oberlo.DTOs.request.UserRegisterDTO;
import com.backend134.oberlo.DTOs.response.UserLoginResponseDTO;
import com.backend134.oberlo.services.impl.RegistrationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class RegistrationController {
    private final RegistrationServiceImpl registrationService;
    @PostMapping("/register")
    ResponseEntity<Void> register(UserRegisterDTO registerDTO){
        registrationService.register(registerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PostMapping("/login")
    ResponseEntity<UserLoginResponseDTO> login(UserLoginDTO loginDTO){
        return ResponseEntity.ok(registrationService.login(loginDTO));
    }
}
