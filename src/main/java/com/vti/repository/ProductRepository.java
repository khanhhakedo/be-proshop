package com.vti.repository;


import com.vti.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

    @Query("SELECT a FROM Product a ")
    Page<Product> findAll(Pageable pageable);

    @Modifying
    @Query("DELETE FROM Product AS p WHERE p.id = :parId")
    void deleteById(@Param("parId") Integer id);

    @Modifying
    @Query("SELECT p FROM Product AS p  ORDER BY p.rating DESC  nulls last " )
    List<Product> getProductDESC ();

}
