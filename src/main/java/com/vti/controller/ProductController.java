package com.vti.controller;


import com.vti.Dto.ProductDto;
import com.vti.entity.Product;

import com.vti.form.FormSeachProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "api/v1/products")

public class ProductController {
    @Autowired
    private com.vti.service.IProductService IProductService;


    @GetMapping()
    public ResponseEntity<?> getAllProducts() {
        List<Product> products = IProductService.getall();
        List<ProductDto> productDtos = new ArrayList<>();
        for (Product product : products) {
            ProductDto productDto = new ProductDto();
            productDto.setId(product.getId());
            productDto.setPrice(product.getPrice());
            productDto.setBrand(product.getBrand());
            productDto.setName(product.getName());
            productDto.setImage(product.getImage());
            productDto.setDescription(product.getDescription());
            productDto.setRating(product.getRating());
            productDto.setCountInStock(product.getCountInStock());
            productDto.setNumReviews(product.getNumReviews());
//            productDto.setCategory(product.getCategory());
            productDto.setCategory(product.getCategory().getCategory());
            productDtos.add(productDto);

        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) {
        Product product = IProductService.getProductById(id);

        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setPrice(product.getPrice());
        productDto.setBrand(product.getBrand());
        productDto.setName(product.getName());
        productDto.setImage(product.getImage());
        productDto.setDescription(product.getDescription());
        productDto.setRating(product.getRating());
        productDto.setCountInStock(product.getCountInStock());
        productDto.setNumReviews(product.getNumReviews());

        productDto.setCategory(product.getCategory().getCategory());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping()
    public List<Product> getProduct(@RequestBody FormSeachProduct form) {
        String a = form.getName();
        Float b = form.getPrice_start();
        Float c = form.getPrice_end();

        if (a== null){
            List<Product> products = IProductService.getall();
            return products;
        }else if (a != null){
            if (b == null){
                List<Product> products = IProductService.findByNameLike("%"+form.getName()+"%");
                return products;
            } else  if (b != null){
                if (c == null){
                    List<Product> products = IProductService.findByPriceGreaterThan(b);
                    return  products;
                }else  if (c!= null){
                    List<Product> products = IProductService.findByPriceLessThan(c);
                    return products;
                }
            }

        }return null;

    }
}
