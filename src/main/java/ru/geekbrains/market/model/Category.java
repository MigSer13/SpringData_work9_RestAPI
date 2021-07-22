package ru.geekbrains.market.model;


import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="categories")
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Product> productList;

    @CreationTimestamp
    @Column(name = "created_at")
    public LocalDate createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    public LocalDate updatedAt;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }
}
