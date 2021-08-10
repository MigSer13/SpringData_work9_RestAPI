package ru.geekbrains.market.controllers;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.market.exeptions.ResourceNotFoundExeption;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.ProductService;
import ru.geekbrains.market.utils.Cart;

@RestController
@Data
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {
    private final Cart cart;
    private final ProductService productService;

    @GetMapping
    public Cart getCart(){
        return cart;
    }

    @GetMapping("/add/{id}")
    public void add(@PathVariable Long id){
        if(cart.add(id)){
            return;
        }
        Product p = productService.findByID(id).orElseThrow(()-> new ResourceNotFoundExeption("Product not found. Adding is not possible. id:" + id));
        cart.add(p);
    }

    @GetMapping("/clear")
    public void clear(){
        cart.clear();
    }
    @GetMapping("/addPiece/{productTitle}")
    public void addPieceFromCart(@PathVariable String productTitle){
        cart.addPieceFromCart(productTitle);
    }
    @GetMapping("/deletePiece/{productId}")
    public void deletePieceFromCart(@PathVariable Long productId){
        cart.deletePieceFromCart(productId);
    }
    @GetMapping("/delete/{productTitle}")
    public void deleteItemsByTitle(@PathVariable String productTitle){
        cart.deleteItemsByTitle(productTitle);
    }

}

