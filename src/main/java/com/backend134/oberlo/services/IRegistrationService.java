package com.backend134.oberlo.services;

import com.backend134.oberlo.DTOs.request.UserLoginDTO;
import com.backend134.oberlo.DTOs.request.UserRegisterDTO;
import com.backend134.oberlo.DTOs.response.UserLoginResponseDTO;

public interface IRegistrationService {
     void register(UserRegisterDTO registerDTO);
     UserLoginResponseDTO login(UserLoginDTO loginDTO);
}
