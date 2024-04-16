package com.macv.stockmicroservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "stock")
@NoArgsConstructor
@Getter
@Setter
public class StockEntity{
    @Id
    private Long id;
    private String code;
    private Integer quantity;
}
