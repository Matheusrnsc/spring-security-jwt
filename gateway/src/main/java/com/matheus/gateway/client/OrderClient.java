package com.matheus.gateway.client;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class OrderClient {

    private final RestClient restClient;

    public OrderClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public List<String> getOrders() {
        return restClient
                .get()
                .uri("http://localhost:8081/api/orders")
                .retrieve()
                .body(new ParameterizedTypeReference<List<String>>() {});
    }

}
