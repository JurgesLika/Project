package dao;

import entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private final SessionFactory sessionFactory;


    public CategoryDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void save(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Category> findAll() {
        try (Session session = sessionFactory.openSession()) {
            Query<Category> query = session.createQuery("FROM Category", Category.class);
            return query.list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Category findById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Category.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void update(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.update(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Category category) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.delete(category);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}