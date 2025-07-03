package com.demo.mapper;

import com.demo.dto.PostProductDto;
import com.demo.dto.PutProductDto;
import com.demo.entities.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product addProduct(PostProductDto productDto) {
        Product product = new Product(
                productDto.name(),
                productDto.price(),
                productDto.description()
        );
        product.setProductId(product.getProductId());
        return product;
    }

    public Product updateProduct(PutProductDto putProductDto) {
        Product product = new Product(
                putProductDto.name(),
                putProductDto.price(),
                putProductDto.description()
        );
        product.setProductId(0L);
        return product;
    }
}
