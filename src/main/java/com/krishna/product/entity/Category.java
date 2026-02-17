package com.krishna.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)  // Cascade.All removes all the products in case a category is removed (i.e. It deletes the child table data in case parent table data is deleted)
    private List<Product> products;
}
