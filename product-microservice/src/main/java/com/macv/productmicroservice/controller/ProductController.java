package com.macv.productmicroservice.controller;


import com.macv.productmicroservice.entity.ProductEntity;
import com.macv.productmicroservice.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/products")
public class ProductController {


    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }

    /*@GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProduct() {
        List<ProductEntity> productEntities = productRepository.findAll();
        ResponseEntity<List<ProductEntity>> responseEntity = new ResponseEntity<>(productEntities, HttpStatus.ok);
        return responseEntity;
    }*/

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public void createProduct(@RequestBody ProductEntity productEntity) {
        productRepository.save(productEntity);
    }
}
