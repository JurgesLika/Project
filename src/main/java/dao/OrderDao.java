package dao;

import entity.Order;
import entity.OrderItems;

public interface OrderDao {
    Long save(Order order);

    void update(Order order);
    Order findById(Long id);

    void saveItems(OrderItems item);
}
