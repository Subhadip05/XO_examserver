package com.exam.service;

import com.exam.entity.exam.Category;

import java.util.Set;

public interface CategoryService {

    public Category addCategory(Category category);

    public Category updateCategory(Category category);

    public Category getCategory(Long categoryId);

    public void deleteCategory(Long categoryId);

    public Set<Category> getCategories();
}
