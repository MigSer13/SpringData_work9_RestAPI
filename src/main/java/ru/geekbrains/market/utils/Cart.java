package ru.geekbrains.market.utils;

import org.springframework.stereotype.Component;
import ru.geekbrains.market.dto.OrderItemDto;
import ru.geekbrains.market.dto.ProductDto;
import ru.geekbrains.market.model.Product;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class Cart {
    private List<OrderItemDto> items;
    private BigDecimal price;

    @PostConstruct
    public void init() {
        this.items = new ArrayList<>();
        this.price = BigDecimal.ZERO;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void clear(){
        items.clear();
        price = BigDecimal.ZERO;
    }

    private void recalculate(){
        price = BigDecimal.ZERO;
        for(OrderItemDto oip : items){
            price = price.add(oip.getPrice());
        }
    }
    public boolean add(Long productId){
        for(OrderItemDto oid : items){
            if(oid.getProductId().equals(productId)){
                oid.incrementQuantity(1);
                recalculate();
                return true;
            }
        }
        return false;
    }

    public void add(Product product){
        items.add(new OrderItemDto(product));
        recalculate();
    }

    public List<OrderItemDto> getItems() {
        return items;
    }

    public List<OrderItemDto> deleteItemsByTitle(String productTitle) {
//        for(OrderItemDto oid : items) {
//            if (oid.getProductTItle().equals(productTitle)) {
//                items.remove(oid);
//            }
//        }
        items.removeIf(oid -> oid.getProductTitle().equals(productTitle));
        recalculate();
        return items;
    }

    public boolean deletePieceFromCart(String productTitle){
        for(OrderItemDto oid : items){
            if (oid.getProductTitle().equals(productTitle) & oid.getQuantity() > 1) {
                oid.decrementQuantity(1);
                recalculate();
                return true;
            }
        }
        return false;
    }

    public boolean addPieceFromCart(String productTitle){
        for(OrderItemDto oid : items){
            if (oid.getProductTitle().equals(productTitle)) {
                oid.incrementQuantity(1);
                recalculate();
                return true;
            }
        }
        return false;
    }

}
