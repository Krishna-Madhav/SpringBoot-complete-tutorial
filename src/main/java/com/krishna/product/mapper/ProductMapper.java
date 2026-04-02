package com.krishna.product.mapper;

import com.krishna.product.dto.ProductDTO;
import com.krishna.product.entity.Category;
import com.krishna.product.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductMapper {

    // convert ProductDTO -> Product entity (table)
    public static Product toProductEntity(ProductDTO productDTO, Category category){

        Product product = new Product();

        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setDescription(productDTO.getDescription());
        product.setCategory(category);

        return product;
    }

    // convert Product entity (table) -> ProductDTO
    public static ProductDTO toProductDTO(Product product){
        ProductDTO productDTO = new ProductDTO();

        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setDescription(product.getDescription());
        productDTO.setCategoryId(product.getCategory().getCategoryId());

        return productDTO;
    }

}
