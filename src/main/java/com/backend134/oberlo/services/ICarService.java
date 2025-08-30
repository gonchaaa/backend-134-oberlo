package com.backend134.oberlo.services;

import com.backend134.oberlo.DTOs.request.CarRequestDTO;
import com.backend134.oberlo.DTOs.response.CarResponseDTO;
import com.backend134.oberlo.entities.Models;

import java.util.List;

public interface ICarService {
    CarResponseDTO createCar (CarRequestDTO carRequestDto);
    CarResponseDTO updateCar(Long id, CarRequestDTO carRequestDto);
    CarResponseDTO getCarbyId(Long id);
    void  deleteCar(Long id);
    List<CarResponseDTO> getAllCars();
    List<CarResponseDTO> getCarsByModels(Models modelId);//modele gore cagirma
    List<CarResponseDTO> getCarsByYear(Integer year);
}
