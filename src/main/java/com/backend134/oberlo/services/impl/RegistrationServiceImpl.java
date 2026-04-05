package com.backend134.oberlo.services.impl;

import com.backend134.oberlo.DTOs.request.UserLoginDTO;
import com.backend134.oberlo.DTOs.request.UserRegisterDTO;
import com.backend134.oberlo.DTOs.response.UserLoginResponseDTO;
import com.backend134.oberlo.entities.Registration;
import com.backend134.oberlo.repositories.RegistrationRepository;
import com.backend134.oberlo.security.JwtService;
import com.backend134.oberlo.services.IRegistrationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements IRegistrationService {

    private final RegistrationRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public void register(UserRegisterDTO registerDTO) {
   try{
       Registration user = Registration.builder()
               .firstName(registerDTO.getFirstName())
               .lastName(registerDTO.getLastName())
               .email(registerDTO.getEmail())
               .password(passwordEncoder.encode(registerDTO.getPassword()))
               .build();

       userRepository.save(user);
   } catch (Exception e) {
       throw new RuntimeException("Qeydiyyat zamanı xəta baş verdi: " + e.getMessage());
   }

    }

    @Override
    public UserLoginResponseDTO login(UserLoginDTO loginDTO) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getEmail(),
                        loginDTO.getPassword()
                )
        );

        Registration user = userRepository.findByEmail(loginDTO.getEmail())
                .orElseThrow(() -> new RuntimeException("İstifadəçi tapılmadı"));

        String token = jwtService.generateToken(user);
        return new UserLoginResponseDTO(token);
    }
}
