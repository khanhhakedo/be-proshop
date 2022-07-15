package com.vti.service;


import com.vti.repository.ProductRepository;
import com.vti.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private ProductRepository productRepository;


    public List<Product> getall() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductById(Integer id) {
        Product product = productRepository.getProductById(id);
        return product;
    }

    @Override
    public List<Product> getProductByName(String name) {
        List<Product> products = productRepository.getProductByName(name);
        return products;
    }

    @Override
    public List<Product> findByNameLike(String namelike) {
        List<Product> products = productRepository.findByNameLike(namelike);
        return products;
    }

    @Override
    public List<Product> findByPriceLessThan(Float pricea) {
        List<Product> products = productRepository.findByPriceLessThan(pricea);
        return products;
    }

    @Override
    public List<Product> findByPriceGreaterThan(Float priceb) {
        List<Product> products = productRepository.findByPriceGreaterThan(priceb);
        return products;
    }


}
