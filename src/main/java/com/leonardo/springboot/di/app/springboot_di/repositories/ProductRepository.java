package com.leonardo.springboot.di.app.springboot_di.repositories;

import java.util.Arrays;
import java.util.List;


import com.leonardo.springboot.di.app.springboot_di.models.Product;

public class ProductRepository {
    private List<Product> data;
    
    public ProductRepository(){
        this.data = Arrays.asList(
            new Product(1L, "Memoria Corsair ", 300L),
            new Product(2L, "CPU Intel i9", 850L),
            new Product(3L, "Teclado Razer Mini", 18L),
            new Product(4L, "Motherboard Gigabyte", 490L)
        );
    }
    public List<Product> findAll(){
        return data;
    }
    public Product findById(Long id){
        return data
                .stream()
                .filter(p->p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
