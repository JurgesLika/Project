package dao;

import entity.OrderItems;
import org.hibernate.SessionFactory;
import entity.Order;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class OrderDaoImpl implements OrderDao{
    private final SessionFactory sessionFactory;

    public OrderDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    @Override
    public Long save(Order order) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            Long orderId = (Long) session.save(order);
            transaction.commit();
            return orderId;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return 0L;
    }

    @Override
    public void update(Order order) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.update(order);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public void saveItems(OrderItems item) {
        try{
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Order findById(Long id) {
        return null;
    }
}
