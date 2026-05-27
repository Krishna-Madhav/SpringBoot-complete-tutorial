package com.krishna.product.service;

import com.krishna.product.dto.ProductDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.entity.Product;
import com.krishna.product.mapper.ProductMapper;
import com.krishna.product.repository.CategoryRepository;
import com.krishna.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    public ProductDTO createProduct(ProductDTO productDTO){

        /**
         * name, description, price, categoryId (These values will be provided by seller using Web UI)
         * <p>
         * At first,fetch categoryID using DTO and then search for Category entity using this ID and in case, if
         * that doesn't exist,then throw an error
         * </p>
         */

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        System.out.println("category******* " + category.toString());

        // Convert ProductDTO -> Product entity -> Persist in DB
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        System.out.println("****** " + product);

        // Convert Product -> ProductDTO and return to controller
        ProductDTO productDTOUpdated = ProductMapper.toProductDTO(product);

        System.out.println("***** productDTOUpdated" + productDTOUpdated);
        System.out.println("***** productDTOUpdated.getProductId " + productDTOUpdated.getProductId());
        return productDTOUpdated;
    }
}
