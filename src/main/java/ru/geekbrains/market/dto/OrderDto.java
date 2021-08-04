package ru.geekbrains.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.market.model.Order;
import ru.geekbrains.market.model.Product;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class OrderDto {
    private Long id;
    private BigDecimal price;

   public OrderDto(Order order) {
        id = order.getId();
        price = order.getPrice();
    }
}
