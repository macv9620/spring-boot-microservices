package com.macv.stockmicroservice.controller;

import com.macv.stockmicroservice.entity.StockEntity;
import com.macv.stockmicroservice.repository.IStockRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/stock")
public class StockController{
    private final IStockRepository stockRepository;

    public StockController(IStockRepository stockRepository){
        this.stockRepository = stockRepository;
    }

    @RequestMapping("/{code}")
    public boolean stockAvailable(@PathVariable String code) {
        Optional<StockEntity> stock = stockRepository.findByCode(code);

        stock.orElseThrow(() -> new RuntimeException("Cannot find the product " + code));

        return stock.get().getQuantity() > 0;
    }
}
