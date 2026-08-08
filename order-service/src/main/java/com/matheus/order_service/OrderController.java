package com.matheus.order_service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

@GetMapping
  public List<String> getAllOrders() {
    return List.of("ContadoJoao", "Senha do João", "Saldo_do_João");
  }
}
