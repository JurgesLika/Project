package service;

import config.HibernateConfig;
import conventer.OrderConventer;
import dao.OrderDao;
import dao.OrderDaoImpl;
import dao.ProductDao;
import dao.ProductDaoImpl;
import dto.OrderItimesRequest;
import dto.OrederRequest;
import entity.Order;
import entity.OrderItems;
import entity.Product;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class OrderServiceImpl implements OrderService{
    private SessionFactory sessionFactory = HibernateConfig.getSessionFactory();
    private OrderDao orderDao = new OrderDaoImpl(sessionFactory);
    private ProductDao productDao = new ProductDaoImpl(sessionFactory);

    @Override
    public void create(OrederRequest request) {
        Order oderEntity = OrderConventer.convertToEntity(request);
        Long orderId =orderDao.save(oderEntity);

        List<Long> productIds = request.getOrderItems()
                .stream().map(OrderItimesRequest::getProductId)
                .collect(Collectors.toList());

        List<Product> productList = productDao.findByIds(productIds);


        Map<Long, Double> productMap =  new HashMap<>();

        productList.stream()
                .forEach(
                        product -> {
                            productMap.put(product.getId(), product.getPrice());
                });

        Double totalPrice = 0D;
        for (OrderItems item: oderEntity.getOrderItems()) {
            System.out.println(item);
            Double price = productMap.get(item.getProduct().getId());
            totalPrice+=price;
            item.setProductPrice(price);
            item.setSubTotal(price* item.getQuantity());
            item.setOrder(new Order(orderId));
            orderDao.saveItems(item);
        }
        oderEntity.setOrderItems(null);
        oderEntity.setTotal(totalPrice);
        oderEntity.setId(orderId);
        orderDao.update(oderEntity);
    }
}
