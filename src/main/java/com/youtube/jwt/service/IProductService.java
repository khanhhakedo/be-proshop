package com.youtube.jwt.service;



import com.youtube.jwt.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getall();
//    List<Product> getProductById (Integer id);

    public Product getProductById(Integer id);
}
