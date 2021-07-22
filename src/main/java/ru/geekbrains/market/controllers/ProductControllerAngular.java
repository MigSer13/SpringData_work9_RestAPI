//package ru.geekbrains.market.controllers;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.data.domain.Page;
//import org.springframework.web.bind.annotation.*;
//import ru.geekbrains.market.model.Product;
//import ru.geekbrains.market.services.ProductService;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//public class ProductControllerAngular {
//    private final ProductService productService;
//
//    @GetMapping("/app/products")
//    public List<Product> showListOfProducts(){
//        return productService.getProductList();
//    }
//
//    @GetMapping("/app/products/{id}")
//    public Product infoOfProduct(@PathVariable Long id){
//        return productService.findByID(id);
//    }
//
//    @GetMapping("/app/products/delete/{id}")
//    public void deleteProductById(@PathVariable Long id){
//        productService.deletedByID(id);
//    }
//
//    @GetMapping("/app/products/page/{numder}")
//    public List<Product> showPageOfProducts(@PathVariable int numder){
//        return productService.findPage(numder-1, 10);
//    }
//
//
//
//
//    //далее остались старые методы из прошлых уроков
//    @GetMapping("/add")
//    public String addProduct(){
//        return "add_form";
//    }
//
//
//    @PostMapping("/app/products")
//    public String addNewProduct(@RequestParam String title, @RequestParam int price){
//        productService.addNew(title, price);
//        return "productsList";
//    }
//
//    @GetMapping("/app/products/minprice")
//    @ResponseBody
//    public List<Product> findAllByPriceGreaterThanEqual(@RequestParam int minPrice){
//        return productService.findAllByPriceGreaterThanEqual(minPrice);
//    }
//
//    @GetMapping("/app/products/maxprice")
//    @ResponseBody
//    public List<Product> findAllByPriceLessThanEqual(@RequestParam int maxPrice){
//        return productService.findAllByPriceLessThanEqual(maxPrice);
//    }
//
//    @GetMapping("/app/products/price_min_max")
//    @ResponseBody
//    public List<Product> findAllByPriceBetween(@RequestParam int min, @RequestParam int max){
//        return productService.findAllByPriceBetween(min, max);
//    }
//
////    @PostMapping("/add_new_product")
////    public String addNewProduct(Model model, @RequestParam int id, @RequestParam String title, @RequestParam int price){
////        String answer = productService.addNewProduct(id, title, price);
////        if(answer.startsWith("Добавлен")){
////            return "redirect:/repository";
////        }else {
////            model.addAttribute("answer", answer);
////            return "add_form";
////        }
////    }
//
//}
