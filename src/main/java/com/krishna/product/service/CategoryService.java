package com.krishna.product.service;

import com.krishna.product.dto.CategoryDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.mapper.CategoryMapper;
import com.krishna.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        // convert CategoryDTO to Category for persisting to DB
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category); // This contains ID as well so Category gets updated with ID field

        // Converting back to CategoryDTO from newly persisted Category entity
        return CategoryMapper.toCategoryDTO(category);
    }

    @GetMapping
    public List<CategoryDTO> getAllCategories() {  // We don't send an Entity as it might contain sensitive data.That's the reason we send DTO as it is a modified version of Entity
        List<Category> allCategory = categoryRepository.findAll();

        // Converting Category entity to Category DTO
        List<CategoryDTO> categoryDTOList = allCategory.stream().map(CategoryMapper::toCategoryDTO).toList();
        return categoryDTOList;
    }

    public CategoryDTO getCategoryById(Long id) {

        Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found!"));

        return CategoryMapper.toCategoryDTO(category);
    }

    public String deleteCategory(Long id) {
        categoryRepository.deleteById(id);
        return "Category " + id + " has been deleted!";

    }
}
