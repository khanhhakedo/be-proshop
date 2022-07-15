package com.vti.service;



import com.vti.entity.Product;

import java.util.List;

public interface IProductService {
    public List<Product> getall();
//    List<Product> getProductById (Integer id);

    public Product getProductById(Integer id);

    List<Product> getProductByName(String name);
    List<Product> findByNameLike(String namelike);
    List<Product> findByPriceLessThan(Float pricea);
    List<Product> findByPriceGreaterThan(Float priceb);
}
