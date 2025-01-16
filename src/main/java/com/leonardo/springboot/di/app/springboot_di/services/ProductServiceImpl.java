package com.leonardo.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.leonardo.springboot.di.app.springboot_di.models.Product;
import com.leonardo.springboot.di.app.springboot_di.repositories.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository repository;
    
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Product> findAll(){
        return repository.findAll();
    }

    public List<Product> findAllWithTaxes() {
        double taxPercentage = (double) 0.16;
        return repository.findAll()
                            .stream()
                            .map(p -> {
                                Double price = p.getPrice()*(1d+taxPercentage);
                                //Product newProduct = new Product(p.getId(), p.getName(), price.longValue());
                                Product newProduct = (Product) p.clone();
                                newProduct.setPrice(price.longValue());
                                return newProduct;
                            })
                            .collect(Collectors.toList());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }
}
