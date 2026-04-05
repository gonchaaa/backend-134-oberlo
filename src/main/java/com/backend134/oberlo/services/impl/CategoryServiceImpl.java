package com.backend134.oberlo.services.impl;

import com.backend134.oberlo.DTOs.request.CategoryRequestDTO;
import com.backend134.oberlo.DTOs.response.CategoryResponseDTO;
import com.backend134.oberlo.entities.Categories;
import com.backend134.oberlo.exceptions.BaseException;
import com.backend134.oberlo.exceptions.ErrorMessage;
import com.backend134.oberlo.exceptions.ErrorsType;
import com.backend134.oberlo.repositories.CategoryRepository;
import com.backend134.oberlo.services.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements ICategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponseDTO createCategory(CategoryRequestDTO categoryRequestDTO) {

        try{
            CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
            Categories category = new Categories();

            category.setCategoryName(categoryRequestDTO.getCategoryName());
            categoryRepository.save(category);
            categoryResponseDTO.setCategoryName(category.getCategoryName());

            return categoryResponseDTO;
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(ErrorsType.CANNOT_CREATED, "Category cannot created"));
        }

    }

    @Override
    public CategoryResponseDTO updateCategory(Long id, CategoryRequestDTO categoryRequestDTO) {


            Optional<Categories> category = categoryRepository.findById(id);

            if (category.isPresent()) {
                    Categories foundCategory = category.get();

                    foundCategory.setCategoryName(categoryRequestDTO.getCategoryName());
                    categoryRepository.save(foundCategory);

                    CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
                    categoryResponseDTO.setId(foundCategory.getId());
                    categoryResponseDTO.setCategoryName(foundCategory.getCategoryName());

                    return categoryResponseDTO;

            }
            throw new BaseException(new ErrorMessage(ErrorsType.CANNOT_UPDATED, "Category not found"));
    }

    @Override
    public CategoryResponseDTO getCategoryById(Long id) {
        Optional<Categories> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            Categories foundCategory = category.get();

            CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
            categoryResponseDTO.setId(foundCategory.getId());
            categoryResponseDTO.setCategoryName(foundCategory.getCategoryName());

            return categoryResponseDTO;
        }

        throw new BaseException(new ErrorMessage(ErrorsType.NO_DATA_FOUND, "Category not found"));

    }

    @Override
    public void deleteCategory(Long id) {
        Optional<Categories> category = categoryRepository.findById(id);
        if (category.isPresent()) {
            categoryRepository.deleteById(id);
        }
    }

    @Override
    public List<CategoryResponseDTO> getAllCategories() {

    List<CategoryResponseDTO> categoryResponseDTOList = new ArrayList<>();
    List<Categories> categories = categoryRepository.findAll();
    try{
        for (Categories category: categories){
            CategoryResponseDTO categoryResponseDTO = new CategoryResponseDTO();
            categoryResponseDTO.setId(category.getId());
            categoryResponseDTO.setCategoryName(category.getCategoryName());
            categoryResponseDTOList.add(categoryResponseDTO);
        }
        return categoryResponseDTOList;
    } catch (Exception e) {
        throw new BaseException(new ErrorMessage(ErrorsType.NO_DATA_FOUND, "No categories found"));
    }

    }
}


//DI -- Dependency Injection is a design pattern used in software development to achieve Inversion of Control (IoC) between classes and their dependencies. It allows for better modularity, testability, and maintainability of code by decoupling the creation of an object from its usage. In Spring, this is typically achieved through annotations like @Autowired, @Service, @Component, etc., which enable the framework to automatically inject dependencies at runtime.