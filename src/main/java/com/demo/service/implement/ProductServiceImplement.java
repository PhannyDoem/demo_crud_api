package com.demo.service.implement;

import com.demo.dto.PostProductDto;
import com.demo.dto.PutProductDto;
import com.demo.entities.Product;
import com.demo.mapper.ProductMapper;
import com.demo.reposistory.ProductRepository;
import com.demo.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ProductServiceImplement implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImplement(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long productId) {
           if(productRepository.findById(productId).isPresent()){
               return Optional.of(productRepository.findById(productId).get());
           }else
               return Optional.empty();
    }

    @Override
    public Product save(PostProductDto productDto) {
        Product product = productMapper.addProduct(productDto);
        return productRepository.save(product);
    }

    @Override
    public Product update(PutProductDto putProductDto, Long productId) {
        productRepository.findById(productId)
                .stream()
                .findFirst()
                .map(
                        product -> {
                            product.setProductId(productId);
                            product.setName(putProductDto.name());
                            product.setPrice(putProductDto.price());
                            product.setDescription(putProductDto.description());
                            return productRepository.save(product);
                        }
                ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
        return productRepository.findById(Objects.requireNonNull(productId)).orElse(null);
    }

    @Override
    public String deleteById(long productId) {
        if (productRepository.findById(productId).isPresent()) {
            productRepository.deleteById(productId);
            return "Product deleted successfully";
        }else
            return "Product not found";
    }
}
