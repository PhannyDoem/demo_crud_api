package com.demo.rest.controller;

import com.demo.dto.PostProductDto;
import com.demo.entities.Product;
import com.demo.service.implement.ProductServiceImplement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
    private final ProductServiceImplement productServiceImplement;
    @Autowired
    public ProductRestController(ProductServiceImplement productServiceImplement) {
        this.productServiceImplement = productServiceImplement;
    }

    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAll() {
        return new ResponseEntity<>(productServiceImplement.findAll(), HttpStatus.OK);
    }

    @GetMapping("products/{productId}")
    public ResponseEntity<Optional<Product>> findById(@PathVariable Long productId) {
        return new ResponseEntity<>(productServiceImplement.findById(productId), HttpStatus.OK);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> save(@RequestBody PostProductDto productDto) {
        return new  ResponseEntity<>(productServiceImplement.save(productDto), HttpStatus.CREATED);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> update(@RequestBody PostProductDto productDto,@PathVariable Long productId) {
        return new ResponseEntity<>(productServiceImplement.update(productDto,productId), HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<String> deleteById(@PathVariable Long productId) {
        return new ResponseEntity<>(productServiceImplement.deleteById(productId), HttpStatus.OK);
    }
}
