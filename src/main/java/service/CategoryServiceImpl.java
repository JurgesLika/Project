package service;

import config.HibernateConfig;
import dao.*;
import entity.Category;
import org.hibernate.SessionFactory;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private CategoryDao categoryDao = new CategoryDaoImpl(sessionFactory);

    @Override
    public void saveCategory(Category category) {
        categoryDao.save(category);
    }

    @Override
    public List<Category> findAllCategories() {
        return categoryDao.findAll();
    }

    @Override
    public Category findCategoryById(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public void updateCategory(Category category) {
        categoryDao.update(category);
    }

    @Override
    public void deleteCategory(Category category) {
        categoryDao.delete(category);
    }
}