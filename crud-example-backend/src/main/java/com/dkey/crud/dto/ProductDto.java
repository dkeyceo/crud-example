package com.dkey.crud.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProductDto {
    @NotBlank
    private String name;
    @Min(0)
    private Double price;

    public ProductDto() {
    }

    public ProductDto(String name, Double price) {
        this.name = name;
        this.price = price;
    }
}
