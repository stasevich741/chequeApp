package com.example.chequeapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "product")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "продукт")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id")
    Long id;

    @Schema(description = "наименование товара")
    @NotBlank(message = "Введите название продукта")
    @Size(min = 2, max = 20)
    String name;

    @Schema(description = "цена в usd")
    @Column(name = "price_usd")
    @DecimalMin(value = "0.0", inclusive = false)
    @DecimalMax(value = "99.99")
    @Digits(integer = 2, fraction = 2)
    BigDecimal priceUSD;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    @JsonIgnore
    ZonedDateTime createDate;
}
