package com.krishna.product.service;

import com.krishna.product.dto.ProductDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.entity.Product;
import com.krishna.product.mapper.ProductMapper;
import com.krishna.product.repository.CategoryRepository;
import com.krishna.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){

        // First of all, find category Id using DTO and then search for Category entity using this ID
        Long categoryId = productDTO.getCategoryId();
        System.out.println("categoryId " + categoryId);
        Category category = categoryRepository.getOne(categoryId);
        System.out.println("category******* " + category.toString());

        // Convert ProductDTO to Product entity to persist in DB
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);
        System.out.println("****** " + product);

        // convert Product to ProductDTO and return to controller
        ProductDTO productDTO1 = ProductMapper.toProductDTO(product);
        System.out.println("***** " + productDTO1);
        return productDTO1;
    }
}
