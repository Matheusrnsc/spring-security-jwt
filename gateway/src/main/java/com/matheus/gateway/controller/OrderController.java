package com.matheus.gateway.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.matheus.gateway.client.OrderClient;

@RestController
@RequestMapping("/api/orders")

public class OrderController {
    
    public final OrderClient orderClient;

    public OrderController(OrderClient orderClient) {
        this.orderClient = orderClient;
    }
    @GetMapping
    public List<String> getOrders() {
        return orderClient.getOrders();
    }
}
