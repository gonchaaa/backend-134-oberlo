package com.backend134.oberlo.controllers;

import com.backend134.oberlo.DTOs.request.ModelRequestDTO;
import com.backend134.oberlo.DTOs.response.ModelResponseDTO;
import com.backend134.oberlo.services.IModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/models")
public class ModelController {

    private final IModelService modelService;

    @PostMapping()
    ModelResponseDTO createModel (@RequestBody ModelRequestDTO modelRequestDto){
        return modelService.createModel(modelRequestDto);
    };
    @PutMapping("/{id}")
    ModelResponseDTO updateModel(@PathVariable(name ="id") Long id,@RequestBody ModelRequestDTO modelRequestDto){
        return modelService.updateModel(id, modelRequestDto);
    };
    @GetMapping("/{id}")
    ModelResponseDTO getModelbyId(@PathVariable(name="id") Long id){
        return modelService.getModelbyId(id);
    };
    @DeleteMapping("/{id}")
    void  deleteModel(@PathVariable(name="id") Long id){
        modelService.deleteModel(id);
    };
    @GetMapping("/getAllModels")
    List<ModelResponseDTO> getAllModels(){
        return modelService.getAllModels();
    };
}
