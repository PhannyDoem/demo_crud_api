package com.demo.service.interfaces;

import com.demo.dto.PostProductDto;
import com.demo.dto.PutProductDto;
import com.demo.entities.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<Product> findAll();
     Optional<Product> findById(Long productId);
     Product save(PostProductDto productDto);
     Product update(PutProductDto putProductDto, Long  productId);
     String deleteById(long productId);
}
