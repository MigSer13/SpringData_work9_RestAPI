package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.market.dto.OrderDto;
import ru.geekbrains.market.services.OrderService;

import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public void createOrder(){
        orderService.createOrder();
    }

    @GetMapping
    public List<OrderDto> getAllOrders(){
        return orderService.findAll().stream().map(OrderDto::new).collect(Collectors.toList());
    }
}
