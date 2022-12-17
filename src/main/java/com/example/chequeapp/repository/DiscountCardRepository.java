package com.example.chequeapp.repository;

import com.example.chequeapp.entity.DiscountCard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountCardRepository extends CrudRepository<DiscountCard,Long> {

}
