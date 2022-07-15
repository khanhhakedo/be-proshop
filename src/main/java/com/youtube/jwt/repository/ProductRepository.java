package com.youtube.jwt.repository;


import com.youtube.jwt.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    List<Product> getProductById (Integer id);

    public Product getProductById(Integer id);
}
