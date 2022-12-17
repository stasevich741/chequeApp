package com.example.chequeapp.controller;

import com.example.chequeapp.entity.CheckPrinter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/check")
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@Tag(name = "Отображение чека",
        description = "Методы для работы с чеками")
public class CheckController {

    @GetMapping(value = {"/{idAndCount}", "/{idAndCount}/{cardNumber}"})
    @Operation(summary = "Получить чек о полнолной стоимости, и скидке по карте, если таковая имеется")
    public String printCheck(@PathVariable List<Integer> idAndCount, @PathVariable(required = false) Integer cardNumber) {
        if (idAndCount.size() % 2 != 0)
            throw new RuntimeException("wrong input param");

        CheckPrinter checkPrinter;
        if (cardNumber != null)
            checkPrinter = new CheckPrinter(idAndCount, cardNumber);
        else checkPrinter = new CheckPrinter(idAndCount);
        return checkPrinter.print();
    }
}
