package com.crypto.currency.repository;

import com.crypto.currency.model.StockType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Repository class for stock type table
 */
@Repository
public interface StockTypeRepository extends JpaRepository<StockType,Integer> {

    StockType findByStockTypeName(String stockName);

    List<StockType> findAll();
}
