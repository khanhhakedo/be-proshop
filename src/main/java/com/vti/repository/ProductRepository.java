package com.vti.repository;


import com.vti.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

//    List<Product> getProductById (Integer id);

    public Product getProductById(Integer id);
}
