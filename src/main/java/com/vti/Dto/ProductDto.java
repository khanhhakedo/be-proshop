package com.vti.Dto;

import lombok.Data;

@Data
public class ProductDto {
    private Integer id;
    private String name;
    private String image;
    private String description;
    private String brand;

    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
}
