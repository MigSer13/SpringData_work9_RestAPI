package ru.geekbrains.market.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.geekbrains.market.dto.OrderItemDto;
import ru.geekbrains.market.exeptions.ResourceNotFoundExeption;
import ru.geekbrains.market.model.Order;
import ru.geekbrains.market.model.OrderItem;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.model.User;
import ru.geekbrains.market.repositories.OrderRepository;
import ru.geekbrains.market.utils.Cart;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final Cart cart;
    private final ProductService productService;

    @Transactional
    public void createOrder(User user){
        Order order = new Order();
        order.setUser(user);
        order.setPrice(cart.getPrice());
        order.setOrderItemList(new ArrayList<>());
        for(OrderItemDto oi : cart.getItems()){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setQuantity(oi.getQuantity());
            Product product = productService.findByID(oi.getProductId()).orElseThrow(()-> new ResourceNotFoundExeption("Product not found"));
            orderItem.setProduct(product);
            orderItem.setPositionPrice(product.getPrice().multiply(BigDecimal.valueOf(oi.getQuantity())));
            orderItem.setPricePerProduct(product.getPrice());
            order.getOrderItemList().add(orderItem);
        }
        orderRepository.save(order);
        cart.clear();
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public List<Order> findByUser(User user){
        return orderRepository.findByUser(user);
    }
}
