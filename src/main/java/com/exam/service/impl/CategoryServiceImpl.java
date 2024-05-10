package com.exam.service.impl;

import com.exam.Repo.CategoryRepo;
import com.exam.entity.exam.Category;
import com.exam.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    public CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Category getCategory(Long categoryId) {
        return this.categoryRepo.findById(categoryId).get();
    }

    @Override
    public void deleteCategory(Long categoryId) {

        Category category = new Category();
        category.setCid(categoryId);
        this.categoryRepo.delete(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepo.findAll());
    }
}
