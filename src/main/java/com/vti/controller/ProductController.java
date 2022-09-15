package com.vti.controller;


import com.vti.Dto.ProductDto;
import com.vti.entity.Product;
import com.vti.form.CreateProductForm;
import com.vti.form.FormSeachProduct;
import com.vti.form.UpdateProductForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> getAllProducts(Pageable pageable) {
        Page<Product> products = IProductService.getAllPage(pageable);
//        List<Product> products = IProductService.getall();
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
            productDto.setCategory(product.getCategory());
//            productDto.setCategory(product.getCategory().getCategory());
            productDtos.add(productDto);

        }
        return new ResponseEntity<>(productDtos, HttpStatus.OK);

    }


    @GetMapping("/top")
    public ResponseEntity<?> getProductsDESC() {
        List<Product> products = IProductService.getProductDESC();
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
            productDto.setCategory(product.getCategory());
//            productDto.setCategory(product.getCategory().getCategory());
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

//        productDto.setCategory(product.getCategory().getCategory());
        productDto.setCategory(product.getCategory());
        return new ResponseEntity<>(productDto, HttpStatus.OK);
    }

    @PostMapping("/seachtest")
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

    // them Product moi
    @PostMapping()
    public ResponseEntity<?> createProduct(@RequestBody CreateProductForm form) {
        IProductService.save(form);
        return new ResponseEntity<String>("Create successfully!", HttpStatus.OK);
    }

    // Sua Product theo productId
    @PutMapping(value = "/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable(name = "id") Integer id, @RequestBody UpdateProductForm form) {
        IProductService.update(id,form);
        return new ResponseEntity<String>("Update successfully!", HttpStatus.OK);
    }

    // Xoa Product theo id
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable(name = "id") Integer id) {
        IProductService.deleteById(id);
        return new ResponseEntity<String>("Delete successfully!", HttpStatus.OK);
    }
}
