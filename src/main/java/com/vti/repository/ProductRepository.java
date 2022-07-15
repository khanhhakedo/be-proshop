package com.vti.repository;


import com.vti.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    List<Product> getProductById (Integer id);

    public Product getProductById(Integer id);
    List<Product> getProductByName(String name);
    List<Product> findByNameLike(String namelike);

    List<Product> findByPriceLessThan(Float pricea);
    List<Product> findByPriceGreaterThan(Float priceb);
}
