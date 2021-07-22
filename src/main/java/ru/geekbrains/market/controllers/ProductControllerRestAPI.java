package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.ProductService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductControllerRestAPI {
    private ProductService productService;

    //Get
    @GetMapping
    public Page<Product> showAllProducts(){
        return productService.findPage(0, 10);
    }

    @GetMapping("/{id}")
    public Product findByID(@PathVariable Long id){
        return productService.findByID(id);
    }

    //Delete
    @DeleteMapping("/{id}")
     public void deletedByID(@PathVariable Long id){
        productService.deletedByID(id);
    }

    //Post
    @PostMapping
    public Product createProduct(@RequestBody Product newProduct){
        Product product = new Product(newProduct.getTitle(), newProduct.getPrice());
        productService.save(product);
        return product;
    }



}
