package com.macv.bookingmicroservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//Nombre del proyecto de microservicio, en este caso stock-microservice
@FeignClient(name = "stock-microservice")
public interface IStockClient{

    @RequestMapping("api/stock/{code}")
    boolean stockAvailable(@PathVariable String code);
}
