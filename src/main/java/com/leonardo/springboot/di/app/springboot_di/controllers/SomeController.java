package com.leonardo.springboot.di.app.springboot_di.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.leonardo.springboot.di.app.springboot_di.services.ProductService;
import com.leonardo.springboot.di.app.springboot_di.models.Product;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/api")
public class SomeController {
    private ProductService service = new ProductService();

   @GetMapping("/allproducts")
   public List<Product> showAllProducts(){
        return service.findAll();
   }

   @GetMapping("/allproductswtaxes")
   public List<Product> productWithTaxes(){
        return service.findAllWithTaxes();
   }

   @GetMapping("/product/{id}")
   public Product getProductById(@PathVariable Long id) {
       return service.findById(id);
   }
   


}
