package com.macv.bookingmicroservice.repository;

import com.macv.bookingmicroservice.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<OrderEntity , Long>{
}
