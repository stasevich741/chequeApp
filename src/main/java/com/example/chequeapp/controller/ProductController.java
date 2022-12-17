package com.example.chequeapp.controller;

import com.example.chequeapp.entity.Product;
import com.example.chequeapp.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Tag(name = "Продукты",
        description = "Все методы для работы с продуктами")
public class ProductController {

    ProductService productService;

    @GetMapping(value = "/", produces = "application/json")
    @Operation(summary = "Получить информацию о всех продуктах")
    public Iterable<Product> getAll() {
        log.info("START endpoint getAll");
        Iterable<Product> products = productService.getAll();
        log.info("END endpoint getAll {}",products);
        return products;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Получить информацию о продукте по его id")
    public Optional<Product> getByid(@PathVariable Long id) {
        log.info("START endpoint getById {}", id);
        Product product = productService.getById(id).get();
        log.info("END endpoint getById {}", product);
        return Optional.of(product);
    }

    @PostMapping(value = "/", produces = "application/json")
    @Operation(summary = "Сохранить информацию о продукте")
    public Product save(@RequestBody Product product) {
        log.info("START endpoint save {}", product);
        return productService.save(product);
    }

    @PutMapping(value = "/", produces = "application/json")
    @Operation(summary = "Изменить информацию о продукте")
    public Product update(@RequestBody Product product) {
        log.info("START endpoint update {}", product);
        return productService.update(product);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Удалить информацию о продукте")
    public void delete(@PathVariable Long id) {
        log.info("START endpoint delete {}", id);
        productService.delete(id);
    }
}
