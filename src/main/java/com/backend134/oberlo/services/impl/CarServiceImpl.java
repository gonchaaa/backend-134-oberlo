package com.backend134.oberlo.services.impl;

import com.backend134.oberlo.DTOs.request.CarRequestDTO;
import com.backend134.oberlo.DTOs.response.CarResponseDTO;
import com.backend134.oberlo.entities.Cars;
import com.backend134.oberlo.entities.Models;
import com.backend134.oberlo.repositories.CarRepository;
import com.backend134.oberlo.repositories.ModelRepository;
import com.backend134.oberlo.services.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements ICarService {

    private final CarRepository carRepository;
    private final ModelRepository modelRepository;

    @Override
    public CarResponseDTO createCar(CarRequestDTO carRequestDto) {

        Models model= modelRepository.findById(carRequestDto.getModelId())
                .orElseThrow(()->new RuntimeException("Model not found with id: "+carRequestDto.getModelId()));

        CarResponseDTO carResponseDTO = new CarResponseDTO();
         Cars car = new Cars();

         car.setCarName(carRequestDto.getCarName());
         car.setYear(carRequestDto.getYear());
         car.setPrice(carRequestDto.getPrice());
         car.setDescription(carRequestDto.getDescription());
         car.setImageUrl(carRequestDto.getImageUrl());
         car.setModelId(model);


         carRepository.save(car);

         carResponseDTO.setCarId(car.getId());
         carResponseDTO.setCarName(car.getCarName());
         carResponseDTO.setYear(car.getYear());
         carResponseDTO.setPrice(car.getPrice());
         carResponseDTO.setDescription(car.getDescription());
         carResponseDTO.setImageUrl(car.getImageUrl());
         carResponseDTO.setModelId(model.getId());

         return carResponseDTO;

    }

    @Override
    public CarResponseDTO updateCar(Long id, CarRequestDTO carRequestDto) {

       Optional<Cars> car = carRepository.findById(id);

       if (car.isPresent()){
           Cars updatedCar = car.get();
           CarResponseDTO carResponseDTO = new CarResponseDTO();
           Models model= modelRepository.findById(carRequestDto.getModelId())
                .orElseThrow(()->new RuntimeException("Model not found with id: "+carRequestDto.getModelId()));

                updatedCar.setCarName(carRequestDto.getCarName());
                updatedCar.setYear(carRequestDto.getYear());
                updatedCar.setPrice(carRequestDto.getPrice());
                updatedCar.setDescription(carRequestDto.getDescription());
                updatedCar.setImageUrl(carRequestDto.getImageUrl());
                updatedCar.setModelId(model);

                carRepository.save(updatedCar);

                carResponseDTO.setCarId(updatedCar.getId());
                carResponseDTO.setCarName(updatedCar.getCarName());
                carResponseDTO.setYear(updatedCar.getYear());
                carResponseDTO.setPrice(updatedCar.getPrice());
                carResponseDTO.setDescription(updatedCar.getDescription());
                carResponseDTO.setImageUrl(updatedCar.getImageUrl());
                carResponseDTO.setModelId(model.getId());
                return carResponseDTO;
       }
         throw new RuntimeException("Car not found with id: "+id);
    }

    @Override
    public CarResponseDTO getCarbyId(Long id) {

        Optional<Cars> car = carRepository.findById(id);
        if (car.isPresent()){
            Cars foundCar = car.get();
            CarResponseDTO carResponseDTO = new CarResponseDTO();
            carResponseDTO.setCarId(foundCar.getId());
            carResponseDTO.setCarName(foundCar.getCarName());
            carResponseDTO.setYear(foundCar.getYear());
            carResponseDTO.setPrice(foundCar.getPrice());
            carResponseDTO.setDescription(foundCar.getDescription());
            carResponseDTO.setImageUrl(foundCar.getImageUrl());
            carResponseDTO.setModelId(foundCar.getModelId().getId());
            return carResponseDTO;
        }
        throw new RuntimeException("Car not found with id: "+id);
    }

    @Override
    public void deleteCar(Long id) {
        Optional<Cars> car = carRepository.findById(id);
        if (car.isPresent()){
            carRepository.deleteById(id);
        }else {
            throw new RuntimeException("Car not found with id: "+id);
        }

    }

    @Override
    public List<CarResponseDTO> getAllCars() {



        return List.of();
    }

    @Override
    public List<CarResponseDTO> getCarsByModels(Models modelId) {

        Optional<Models> models = carRepository.findByModelId(modelId.getId());
        if (models.isEmpty()) {
            throw new RuntimeException("No cars found for model id: " + modelId.getId());
        }
        return models.stream()
                .map(m -> {
                    Optional<Cars> car = carRepository.findById(m.getId());
                    if (car.isEmpty()) {
                        throw new RuntimeException("Car not found for id: " + m.getId());
                    }
                    Cars foundCar = car.get();

                    CarResponseDTO dto = new CarResponseDTO();
                    dto.setCarId(foundCar.getId());
                    dto.setCarName(foundCar.getCarName());
                    dto.setYear(foundCar.getYear());
                    dto.setPrice(foundCar.getPrice());
                    dto.setDescription(foundCar.getDescription());
                    dto.setImageUrl(foundCar.getImageUrl());
                    dto.setModelId(foundCar.getModelId().getId());
                    return dto;
                })
                .toList();


    }


    @Override
    public List<CarResponseDTO> getCarsByYear(Integer year) {
        return List.of();
    }
}
