package com.backend134.oberlo.contrtollers;

import com.backend134.oberlo.DTOs.request.CarRequestDTO;
import com.backend134.oberlo.DTOs.response.CarResponseDTO;
import com.backend134.oberlo.entities.Models;
import com.backend134.oberlo.services.ICarService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/cars")
public class CarController {

    private final ICarService carService;

    @PostMapping()
    CarResponseDTO createCar (@RequestBody CarRequestDTO carRequestDto){
      return carService.createCar(carRequestDto);
    };
    @PutMapping("/{id}")
    CarResponseDTO updateCar(@PathVariable(name="id") Long id,@RequestBody CarRequestDTO carRequestDto){
        return carService.updateCar(id, carRequestDto);
    }
    @DeleteMapping("/{id}")
    void  deleteCar(@PathVariable(name = "id") Long id){
        carService.deleteCar(id);
    }
    @GetMapping()
    List<CarResponseDTO> getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping("/{id}")
    CarResponseDTO getCarbyId(Long id){
        return carService.getCarbyId(id);
    }
    @GetMapping("/getCarsByModels")
    List<CarResponseDTO> getCarsByModels(@RequestParam Models model){
        return carService.getCarsByModels(model);
    }
    @GetMapping("/getCarsByYear")
    List<CarResponseDTO> getCarsByYear(@RequestParam Integer year){
        return carService.getCarsByYear(year);
    }
}
