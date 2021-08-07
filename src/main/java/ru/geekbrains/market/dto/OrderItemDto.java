package ru.geekbrains.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.ProductService;

import java.math.BigDecimal;

@NoArgsConstructor
@Data
public class OrderItemDto {
    private Long productId;
    private String productTitle;
    private BigDecimal pricePerProduct;
    private BigDecimal positionPrice;
    private int quantity;

    public OrderItemDto(Product product) {
        this.quantity = 1;
        this.pricePerProduct = product.getPrice();
        this.positionPrice = product.getPrice();
        this.productId = product.getId();
        this.productTitle = product.getTitle();
    }

    public BigDecimal getPrice() {
        return positionPrice;
    }

    public void incrementQuantity(int amount){
        quantity += amount;
        positionPrice = pricePerProduct.multiply(BigDecimal.valueOf(quantity));
    }
    public void decrementQuantity(int amount){
        quantity -= amount;
        positionPrice = pricePerProduct.multiply(BigDecimal.valueOf(quantity));
    }
}
