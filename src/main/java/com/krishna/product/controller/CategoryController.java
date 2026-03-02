package com.krishna.product.controller;

import com.krishna.product.dto.CategoryDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    // create a category
    @PostMapping
    public Category createCategory(@RequestBody Category category){

        categoryService.createCategory(category);
        return category;
    }

    // get a category based on id
    // get all categories
    // delete a category
}
