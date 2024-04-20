package service;

import config.HibernateConfig;
import conventer.ProductConventer;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dto.ProductRequest;
import entity.Product;
import org.hibernate.SessionFactory;
import validator.ProductValidator;

public class ProductServiceImpl implements ProductService{
    SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    ProductDao productDao = new ProductDaoImpl(sessionFactory);

    @Override
    public void create(ProductRequest request) {
        ProductValidator
                .validateProduct(request);
        Product product = ProductConventer
                .convertToEntity(request);
        productDao.save(product);
    }
}
