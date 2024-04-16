package com.macv.bookingmicroservice.dto;

import com.macv.bookingmicroservice.entity.OrderItemEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private List<OrderItemEntity> orderItems;
}
