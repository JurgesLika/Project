package service;

import entity.Category;

import java.util.List;

public interface CategoryService {
    void saveCategory(Category category);
    List<Category> findAllCategories();
    Category findCategoryById(Long id);
    void updateCategory(Category category);
    void deleteCategory(Category category);
}