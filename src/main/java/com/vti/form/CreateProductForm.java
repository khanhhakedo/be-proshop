package com.vti.form;


import lombok.Data;

@Data
public class CreateProductForm {

    private String name = "ProductNew";
    private String image = "/images/sample.jpg";
    private String description;
    private String brand;
//    private Integer categoryId = 1;
    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
}
