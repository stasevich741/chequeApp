package com.example.chequeapp.service.implementation;

import com.example.chequeapp.entity.Product;
import com.example.chequeapp.repository.ProductRepository;
import com.example.chequeapp.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product productToUpdate = productRepository
                .findById(product.getId()).get();
        return save(productToUpdate);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}
