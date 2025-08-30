package com.backend134.oberlo.services.impl;

import com.backend134.oberlo.DTOs.request.ModelRequestDTO;
import com.backend134.oberlo.DTOs.response.ModelResponseDTO;
import com.backend134.oberlo.entities.Models;
import com.backend134.oberlo.repositories.ModelRepository;
import com.backend134.oberlo.services.IModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ModelServiceImpl implements IModelService {
    private final ModelRepository modelRepository;
    @Override
    public ModelResponseDTO createModel(ModelRequestDTO modelRequestDto) {
        ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
        Models model = new Models();
        model.setModelName(modelRequestDto.getModelsName());
        modelRepository.save(model);
        modelResponseDTO.setId(model.getId());
        modelResponseDTO.setModelsName(model.getModelName());
        return modelResponseDTO;
    }

    @Override
    public ModelResponseDTO updateModel(Long id, ModelRequestDTO modelRequestDto) {
        Optional<Models> model = modelRepository.findById(id);
        if (model.isPresent()) {
            Models foundModel = model.get();
            foundModel.setModelName(modelRequestDto.getModelsName());
            modelRepository.save(foundModel);

            ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
            modelResponseDTO.setId(foundModel.getId());
            modelResponseDTO.setModelsName(foundModel.getModelName());

            return modelResponseDTO;
        }
        return null;
    }

    @Override
    public ModelResponseDTO getModelbyId(Long id) {
        Optional<Models> model = modelRepository.findById(id);
        if (model.isPresent()) {
            Models foundModel = model.get();

            ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
            modelResponseDTO.setId(foundModel.getId());
            modelResponseDTO.setModelsName(foundModel.getModelName());

            return modelResponseDTO;
        }
        return null;
    }

    @Override
    public void deleteModel(Long id) {
        Optional<Models> model = modelRepository.findById(id);
        if (model.isPresent()) {
            modelRepository.delete(model.get());
        }

    }

    @Override
    public List<ModelResponseDTO> getAllModels() {
    List<Models> models = modelRepository.findAll();
    List<ModelResponseDTO> modelResponseDTOs = new ArrayList<>();
    for (Models model : models) {
        ModelResponseDTO modelResponseDTO = new ModelResponseDTO();
        modelResponseDTO.setId(model.getId());
        modelResponseDTO.setModelsName(model.getModelName());
        modelResponseDTOs.add(modelResponseDTO);
    }
        return modelResponseDTOs;
    }
    //by Narmin
}
