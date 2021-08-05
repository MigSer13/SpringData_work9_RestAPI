package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.market.dto.ProductDto;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.ProductService;
import ru.geekbrains.market.exeptions.ResourceNotFoundExeption;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/products")
public class ProductControllerRestAPI {
    private ProductService productService;

    @Autowired
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }

    //Get
    @GetMapping
    public Page<ProductDto> showAllProducts(){
        Page<ProductDto> productDtoPage = productService.findPage(0, 10).map(ProductDto::new);
        return productDtoPage;
    }

    @GetMapping("/page/{id}")
    public Page<ProductDto> showPageProducts(@PathVariable int id){
        Page<ProductDto> productDtoPage = productService.findPage( id-1, 10).map(ProductDto::new);
        return productDtoPage;
    }

    @GetMapping("/{id}")
    public ProductDto findByID(@PathVariable Long id){
        Product p = productService.findByID(id).orElseThrow(()-> new ResourceNotFoundExeption("Product not found, id: " + id ));
        return new ProductDto(p);
    }

    //Delete
    @GetMapping("/delete/{id}")
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
