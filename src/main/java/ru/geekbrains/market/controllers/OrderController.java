package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.market.dto.OrderDto;
import ru.geekbrains.market.model.User;
import ru.geekbrains.market.services.OrderService;
import ru.geekbrains.market.services.UserService;

import java.security.Principal;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;
    private final UserService userService;

    @PostMapping
    public void createOrder(Principal principal) {
        User user = userService.findByUsername(principal.getName()).get();
        orderService.createOrder();
    }

    @GetMapping
    public List<OrderDto> getAllOrders(){
        List<OrderDto> orderDtoList = orderService.findAll().stream().map(OrderDto::new).collect(Collectors.toList());
        return orderDtoList;
    }
}
