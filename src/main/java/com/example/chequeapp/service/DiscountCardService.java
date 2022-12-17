package com.example.chequeapp.service;

import com.example.chequeapp.entity.DiscountCard;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface DiscountCardService {

    Iterable<DiscountCard> getAll();

    Optional<DiscountCard> getById(Long id);


    DiscountCard update(DiscountCard discountCard);

    DiscountCard save(DiscountCard discountCard);

    void delete(Long id);
}
