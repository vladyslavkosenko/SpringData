package com.example.SpringData;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/products")
@RestController
public class ProductController {

    @Autowired
    private ProductRepository repository;

    @GetMapping
    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    @PostMapping("/example")
    public Iterable<Product> getProductsByExample(@RequestBody Product product) {
        Example<Product> example = Example.of(product);
        return repository.findAll(example);
    }

    @PostMapping("/specification")
    public Iterable<Product> getProductsByExample(@RequestParam Integer priceFrom) {
        ProductSpecification specification = new ProductSpecification(priceFrom);
        return repository.findAll(specification);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }
}