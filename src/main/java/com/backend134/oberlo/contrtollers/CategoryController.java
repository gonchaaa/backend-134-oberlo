package com.backend134.oberlo.contrtollers;

import com.backend134.oberlo.DTOs.request.CategoryRequestDTO;
import com.backend134.oberlo.DTOs.response.CategoryResponseDTO;
import com.backend134.oberlo.services.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private final CategoryServiceImpl categoryService;

    @PostMapping()
    CategoryResponseDTO createCategory(@RequestBody CategoryRequestDTO categoryRequestDTO){
        return categoryService.createCategory(categoryRequestDTO);
    };
    @PutMapping("/{id}")
    CategoryResponseDTO updateCategory(@PathVariable(name = "id") Long id,@RequestBody CategoryRequestDTO categoryRequestDTO){
        return categoryService.updateCategory(id, categoryRequestDTO);
    };
    @GetMapping("/{id}")
    CategoryResponseDTO getCategoryById(@PathVariable(name="id") Long id){
        return categoryService.getCategoryById(id);
    };
    @DeleteMapping("/{id}")
    void deleteCategory(@PathVariable(name = "id") Long id){
        categoryService.deleteCategory(id);
    };
    @GetMapping("/getAllCategories")
    List<CategoryResponseDTO> getAllCategories(){
        return categoryService.getAllCategories();
    };
}
