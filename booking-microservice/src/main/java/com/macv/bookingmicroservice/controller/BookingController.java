package com.macv.bookingmicroservice.controller;

import com.macv.bookingmicroservice.client.IStockClient;
import com.macv.bookingmicroservice.dto.OrderDTO;
import com.macv.bookingmicroservice.entity.OrderEntity;
import com.macv.bookingmicroservice.repository.IOrderRepository;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api/booking")
public class BookingController {

    private final IOrderRepository orderRepository;

    private final IStockClient stockClient;

    public BookingController(IOrderRepository orderRepository, IStockClient stockClient){
        this.orderRepository = orderRepository;
        this.stockClient = stockClient;
    }

    @PostMapping("/order")
    @HystrixCommand(fallbackMethod = "fallbackToStockService")
    public String saveOrder(@RequestBody OrderDTO orderDTO) {

        boolean inStock = orderDTO
                .getOrderItems()
                .stream()
                .allMatch(orderItem -> stockClient.stockAvailable(orderItem.getCode()));

        if (inStock) {
            OrderEntity order = new OrderEntity();

            order.setOrderNo(UUID.randomUUID().toString());
            order.setOrderItems(orderDTO.getOrderItems());

            orderRepository.save(order);

            return "Order Saved";
        }

        return  "At least one item doesn't have stock, order cannot be created";
    }

    private String fallbackToStockService(){
        return "Something went wrong, please try again later";
    }
}
