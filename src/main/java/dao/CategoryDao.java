package dao;

import entity.Category;

import java.util.List;

public interface CategoryDao {
    void save(Category category);
    List<Category> findAll();
    Category findById(Long id);
    void update(Category category);
    void delete(Category category);
}