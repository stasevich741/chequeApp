package com.example.chequeapp.entity;

import com.example.chequeapp.constant.CheckConstants;
import com.example.chequeapp.service.DiscountCardService;
import com.example.chequeapp.service.ProductService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
//@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Builder
public class CheckPrinter {

    List<Integer> idAndCount;
    Integer discountCard;
    @Autowired
    DiscountCardService discountCardService;
    @Autowired
    ProductService productService;

    public CheckPrinter(List<Integer> idAndCount, Integer cardNumber) {
    }

    public CheckPrinter(List<Integer> idAndCount) {
    }

    public String print() {
//                Map<String,Integer> idAndCounts = makeMapWithIdAndCount();


        return CheckConstants.HEADER
                + CheckConstants.CASHIER
                + "\n"
                + CheckConstants.DATE_AND_TIME
                + "\n"
                + CheckConstants.DIVIDING_LINE

                + CheckConstants.DIVIDING_LINE
                ;

    }

    Map<String,Integer> makeMapWithIdAndCount() {
        Map<String, Integer> idAndPrice = new HashMap<>();
        for (int i = 0; i < idAndCount.size(); i += 2) {
            idAndPrice.put(idAndCount.get(i).toString(), idAndCount.get(i + 1));
        }
        return idAndPrice;
    }
}
