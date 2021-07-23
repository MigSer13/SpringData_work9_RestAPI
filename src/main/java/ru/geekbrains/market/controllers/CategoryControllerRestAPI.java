package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.market.dto.CategoryDto;
import ru.geekbrains.market.dto.ProductDto;
import ru.geekbrains.market.model.Category;
import ru.geekbrains.market.model.Product;
import ru.geekbrains.market.services.CategoryService;
import ru.geekbrains.market.utils.ResourceNotFoundExeption;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryControllerRestAPI {
    private CategoryService categoryService;

    @Autowired
    public void setCategoryService(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //Get
    @GetMapping
    public List<CategoryDto> findAll(){
        return categoryService.findAll().stream().map(category -> new CategoryDto(category)).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable Long id){
        Category c = categoryService.findById(id).orElseThrow(()-> new ResourceNotFoundExeption("Category not found, id: " + id ));
        return c;
    }
}
