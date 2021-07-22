package ru.geekbrains.market.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.geekbrains.market.dt.CategoryDto;
import ru.geekbrains.market.services.CategoryService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryControllerRestAPI {
    private CategoryService categoryService;

    //Get
    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable Long id){
        return new CategoryDto(categoryService.findById(id));
    }
}
