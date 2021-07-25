package ru.geekbrains.market.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.geekbrains.market.model.Product;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String title;
    private BigDecimal price;
    private String categoryTitle;

    public ProductDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.categoryTitle = product.getCategory().getTitle();
        this.price = product.getPrice();
    }
}
