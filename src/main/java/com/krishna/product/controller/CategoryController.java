package com.krishna.product.controller;

import com.krishna.product.dto.CategoryDTO;
import com.krishna.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO categoryDTO){

        CategoryDTO responseCategoryDTO = categoryService.createCategory(categoryDTO);
        return new ResponseEntity<>(responseCategoryDTO, HttpStatus.CREATED);
    }

    // get a category based on id
    // get all categories
    // delete a category
}