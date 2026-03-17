package com.krishna.product.service;

import com.krishna.product.dto.CategoryDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.mapper.CategoryMapper;
import com.krishna.product.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        // convert CategoryDTO to Category for persisting to DB
        Category category = CategoryMapper.toCategoryEntity(categoryDTO);
        category = categoryRepository.save(category); // This contains ID as well

        // Converting back to CategoryDTO from newly persisted Category entity
        return CategoryMapper.toCategoryDTO(category);
    }
}
