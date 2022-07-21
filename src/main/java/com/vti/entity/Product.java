package com.vti.entity;

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
//    @ManyToOne
//    @JoinColumn(name = "CategoryID")
    private String category;
    private Float price;
    private Integer countInStock;
    private Float rating;
    private Integer numReviews;
//    private String category;


}

