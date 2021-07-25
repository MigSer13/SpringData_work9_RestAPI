//package ru.geekbrains.market.model;
//
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import org.hibernate.annotations.CreationTimestamp;
//import org.hibernate.annotations.UpdateTimestamp;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.*;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//
//@Entity
//@Table(name="orderItems")
//@Data
//@NoArgsConstructor
//@Component
//public class OrderItem {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="id")
//    private Long id;
//    @Column(name="productId")
//    private Long productId;
//    @Column(name="pricePerProduct")
//    private BigDecimal pricePerProduct;
//    @Column(name = "positionPrice")
//    private BigDecimal positionPrice;
//    @Column(name = "quantity")
//    private int quantity;
//    @CreationTimestamp
//    @Column(name = "created_at")
//    public LocalDate createdAt;
//    @UpdateTimestamp
//    @Column(name = "updated_at")
//    public LocalDate updatedAt;
//
//
//
//}
