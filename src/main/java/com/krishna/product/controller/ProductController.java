package com.krishna.product.controller;

import com.krishna.product.dto.ProductDTO;
import com.krishna.product.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductController {

    private ProductService productService;

    // create a product
    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){

        ProductDTO dto = productService.createProduct(productDTO);
        return dto;

    }

    // get a product based on id
    // get all products
    // update a product based on id
    // delete a product

}
