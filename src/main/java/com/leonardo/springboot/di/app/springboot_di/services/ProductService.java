package com.leonardo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.leonardo.springboot.di.app.springboot_di.models.Product;
import com.leonardo.springboot.di.app.springboot_di.repositories.ProductRepository;

public class ProductService {

    private ProductRepository repository = new ProductRepository();
    
    public List<Product> findAll(){
        return repository.findAll();
    }

    public List<Product> findAllWithTaxes() {
        double taxPercentage = (double) 0.16;
        return repository.findAll()
                            .stream()
                            .map(p -> {
                                Double price= p.getPrice()*(1d+taxPercentage);
                                p.setPrice(price.longValue());
                                return p;
                            })
                            .collect(Collectors.toList());
    }

    public Product findById(Long id) {
        return repository.findById(id);
    }
}
