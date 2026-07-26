package com.krishna.product.service;

import com.krishna.product.dto.ProductDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.entity.Product;
import com.krishna.product.mapper.ProductMapper;
import com.krishna.product.repository.CategoryRepository;
import com.krishna.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;

    private CategoryRepository categoryRepository;

    // create a new product
    public ProductDTO createProduct(ProductDTO productDTO){

        /*
         * name, description, price, categoryId (These values will be provided by seller using Web UI)
         *
         * At first,fetch categoryID using DTO and then search for Category entity using this ID and in case, if
         * that doesn't exist,then throw an error
         *
         */

        Category category = categoryRepository.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found!"));

        System.out.println("category******* " + category.toString());

        // Convert ProductDTO -> Product entity -> Persist in DB
        Product product = ProductMapper.toProductEntity(productDTO, category);
        product = productRepository.save(product);

        System.out.println("****** " + product);

        // Convert Product Entity -> ProductDTO and return to controller
        ProductDTO productDTOUpdated = ProductMapper.toProductDTO(product);
        return productDTOUpdated;
    }

    // get all products
    public List<ProductDTO> getAllProducts() {

        List<Product> productList = productRepository.findAll();
        return productList.stream().map(ProductMapper::toProductDTO).toList();
    }

    // get a product based on ID
    public ProductDTO  getProductById(Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!"));

        return ProductMapper.toProductDTO(product);
    }

    // update a product based on ID
    public ProductDTO updateProduct(Long id, ProductDTO productDTO){

        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found!")); // While updating check if product with given Id exists
        Category category = categoryRepository.findById(productDTO.getCategoryId()).orElseThrow(() -> new RuntimeException("Category not found!")); // While updating check if category with given Id exists

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);
        productRepository.save(product);

        return ProductMapper.toProductDTO(product);
    }

    public String deleteProduct(Long id){
        productRepository.deleteById(id);
        return "Product" + id + " has been deleted!";
    }
}
