package ru.geekbrains.market.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.geekbrains.market.model.Category;


@Data
@RequiredArgsConstructor
public class CategoryDto {
    private Long id;
    private String title;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.title = category.getTitle();
    }



}
