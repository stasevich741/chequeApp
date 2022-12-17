package com.example.chequeapp.service.implementation;

import com.example.chequeapp.entity.DiscountCard;
import com.example.chequeapp.repository.DiscountCardRepository;
import com.example.chequeapp.service.DiscountCardService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class DiscountCardServiceImpl implements DiscountCardService {

    DiscountCardRepository discountCardRepository;

    @Override
    public Iterable<DiscountCard> getAll() {
        return discountCardRepository.findAll();
    }

    @Override
    public Optional<DiscountCard> getById(Long id) {
        return discountCardRepository.findById(id);
    }

    @Override
    public DiscountCard save(DiscountCard discountCard) {
        return discountCardRepository.save(discountCard);
    }

    @Override
    public DiscountCard update(DiscountCard discountCard) {
        DiscountCard cardToUpdate = discountCardRepository
                .findById(discountCard.getId()).get();
        return save(cardToUpdate);
    }
    @Override
    public void delete(Long id) {
        discountCardRepository.deleteById(id);
    }
}
