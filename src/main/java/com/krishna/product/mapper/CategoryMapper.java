package com.krishna.product.mapper;

import com.krishna.product.dto.CategoryDTO;
import com.krishna.product.entity.Category;

public class CategoryMapper {

    // Category Entity (saved as table) -> CategoryDTO
    public static CategoryDTO toCategoryDTO(Category category) {

        if (category == null) {
            return null;
        }

        CategoryDTO categoryDTO = new CategoryDTO();

        categoryDTO.setId(category.getId());
        categoryDTO.setName(category.getName());
        categoryDTO.setProducts(category.getProducts()
                .stream()
                .map(product -> ProductMapper.toProductDTO(product))
                .toList());

        return categoryDTO;
    }

    // CategoryDTO -> Category
    public static Category toCategoryEntity(CategoryDTO categoryDTO) {
        Category category = new Category();

        category.setName(categoryDTO.getName());
        return category;
    }
}
