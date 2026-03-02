package com.krishna.product.service;

import com.krishna.product.dto.CategoryDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){

        Category newCategory = categoryRepository.save(category);
        return newCategory;
    }
}
