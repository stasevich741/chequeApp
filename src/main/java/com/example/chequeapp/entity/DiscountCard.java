package com.example.chequeapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "discount_card")
@Schema(description = "скидочная карта")
public class DiscountCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "id")
    Long id;

    @Column(name = "card_number")
    @Schema(description = "номер карты")
    @Digits(integer = 4, fraction = 0)
    Integer cardNumber;

    @Column(name = "discount_percent")
    @Schema(description = "процент скидки")
    @DecimalMin(value = "0")
    @DecimalMax(value = "99")
    Integer discountPercent;

    @CreationTimestamp
    @Column(name = "create_date", updatable = false)
    @JsonIgnore
    ZonedDateTime createDate;
}
