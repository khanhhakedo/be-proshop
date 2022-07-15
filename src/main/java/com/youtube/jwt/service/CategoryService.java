package com.youtube.jwt.service;


import com.youtube.jwt.entity.Category;
import com.youtube.jwt.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getall() {
        return categoryRepository.findAll();
    }
}
