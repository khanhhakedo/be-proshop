package com.vti.form;

import lombok.Data;

@Data
public class UpdateProductForm {
    private String name;
    private String image;
    private String description;
    private String brand;
//    private Integer categoryId;
    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
}
