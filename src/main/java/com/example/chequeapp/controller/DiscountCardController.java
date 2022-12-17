package com.example.chequeapp.controller;

import com.example.chequeapp.entity.DiscountCard;
import com.example.chequeapp.service.DiscountCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cards")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Tag(name = "скидочные карты",
        description = "Все методы для работы с картами")
public class DiscountCardController {

    DiscountCardService discountCardService;

    @GetMapping(value = "/", produces = "application/json")
    @Operation(summary = "Получить информацию о всех картах")
    public Iterable<DiscountCard> getAll() {
        log.info("START endpoint getAll");
        Iterable<DiscountCard> cards = discountCardService.getAll();
        log.info("END endpoint getAll {}", cards);
        return cards;
    }

//    @ExceptionHandler(CommonException.class)
    @GetMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Получить информацию о карте по её id")
    public Optional<DiscountCard> getById(@PathVariable Long id) {
        log.info("START endpoint getById {}", id);
        DiscountCard discountCard = discountCardService.getById(id).get();
        log.info("END endpoint getById {}", discountCard);
        return Optional.of(discountCard);
    }

    @PostMapping(value = "/", produces = "application/json")
    @Operation(summary = "Сохранить информацию о карте")
    public DiscountCard save(@RequestBody DiscountCard discountCard) {
        log.info("START endpoint save {}", discountCard);
        return discountCardService.save(discountCard);
    }

    @PutMapping(value = "/", produces = "application/json")
    @Operation(summary = "Изменить информацию о карте")
    public DiscountCard update(@RequestBody DiscountCard discountCard) {
        log.info("START endpoint update {}", discountCard);
        return discountCardService.update(discountCard);
    }

    @DeleteMapping(value = "/{id}", produces = "application/json")
    @Operation(summary = "Удалить информацию о карте")
    public void delete(@PathVariable Long id) {
        log.info("START endpoint delete {}", id);
        discountCardService.delete(id);
    }
}
