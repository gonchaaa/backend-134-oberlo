package com.backend134.oberlo.services;

import com.backend134.oberlo.DTOs.request.CategoryRequestDTO;
import com.backend134.oberlo.DTOs.response.CategoryResponseDTO;

import java.util.List;

public interface ICategoryService {
    CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO);
    CategoryResponseDTO getCategoryById(Long id);
    void deleteCategory(Long id);
    List<CategoryResponseDTO> getAllCategories();
}
