package com.krishna.product.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

    private Long productId;

    private String name;

    private int price;

    private String description;

    private Long categoryId;
}
