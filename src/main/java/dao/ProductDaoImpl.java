package dao;

import org.hibernate.SessionFactory;
import entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class ProductDaoImpl implements ProductDao{
    private final SessionFactory sessionFactory;

    public ProductDaoImpl(SessionFactory sessionFactory) {

        this.sessionFactory = sessionFactory;
    }//Dependesi injection.

    @Override
    public void save(Product product) {
        try{
           Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Product> findAll() {
        return null;
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public List<Product> findByIds(List<Long>ids) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("FROM Product p WHERE p.id IN :ids");
        query.setParameter("ids", ids);
        return query.getResultList();
    }
}
