package com.vti.service;



import com.vti.entity.Product;
import com.vti.form.CreateProductForm;
import com.vti.form.UpdateProductForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProductService {
    public List<Product> getall();
//    List<Product> getProductById (Integer id);

    public Product getProductById(Integer id);
    Page<Product> getAllPage(Pageable pageable);

    List<Product> getProductByName(String name);
    List<Product> findByNameLike(String namelike);
    List<Product> findByPriceLessThan(Float pricea);
    List<Product> findByPriceGreaterThan(Float priceb);

    public  void  save(CreateProductForm form);
    public  void update(Integer id, UpdateProductForm form);

    public void deleteById(Integer id);

    List<Product> getProductDESC ();
}
