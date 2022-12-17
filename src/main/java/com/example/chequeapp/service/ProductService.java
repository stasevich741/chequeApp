package com.example.chequeapp.service;

import com.example.chequeapp.entity.Product;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ProductService {

    Iterable<Product> getAll();

    Optional<Product> getById(Long id);

    Product save(Product product);

    Product update(Product product);

    void delete(Long id);
}
