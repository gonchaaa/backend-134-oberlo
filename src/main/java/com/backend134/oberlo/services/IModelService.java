package com.backend134.oberlo.services;

import com.backend134.oberlo.DTOs.request.ModelRequestDTO;
import com.backend134.oberlo.DTOs.response.ModelResponseDTO;

import java.util.List;

public interface IModelService {
    ModelResponseDTO createModel (ModelRequestDTO modelRequestDto);
    ModelResponseDTO updateModel(Long id,ModelRequestDTO modelRequestDto);
    ModelResponseDTO getModelbyId(Long id);
    void  deleteModel(Long id);
    List<ModelResponseDTO> getAllModels();
}
