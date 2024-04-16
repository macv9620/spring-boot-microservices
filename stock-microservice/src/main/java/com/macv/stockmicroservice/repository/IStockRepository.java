package com.macv.stockmicroservice.repository;

import com.macv.stockmicroservice.entity.StockEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStockRepository extends JpaRepository<StockEntity, Long>{
    Optional<StockEntity> findByCode(String code);
}
