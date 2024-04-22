package dao;

import entity.Product;

import java.util.List;

public interface ProductDao {
    void save(Product product);
    List<Product> findAll();
    Product findById(Long id);
    List<Product> findByIds(List<Long>ids);
}
