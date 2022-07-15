package com.youtube.jwt.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "Product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String image;
    private String description;
    private String brand;
    @ManyToOne
    @JoinColumn(name = "CategoryID")
    private Category category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
//    private String category;


}

