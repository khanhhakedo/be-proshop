package com.vti.form;

import com.vti.entity.Category;
import lombok.Data;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
public class CreateProductForm {

    private String name;
    private String image;
    private String description;
    private String brand;
    private Integer categoryId;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
}
