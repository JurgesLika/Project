package conventer;

import dto.OrderItimesRequest;
import dto.OrederRequest;
import entity.*;

import java.util.ArrayList;
import java.util.List;

public class OrderConventer {
    public static Order convertToEntity(OrederRequest request){
        Order order = new Order();
        order.setClient(new Client(request.getClientId()));
        order.setOrderStatusEnum(OrderStatusEnum.New);
        order.setPaymentStatusEnum(request.getPeymentStatus());
        order.setOrderItems(convertToEntity(request.getOrderItems()));

        return order;
    }
    public static List<OrderItems> convertToEntity(List<OrderItimesRequest>orderItimesRequests){
        List<OrderItems>orderItems=new ArrayList<>();
        for(OrderItimesRequest request :orderItimesRequests ){
            OrderItems orderItems1 = new OrderItems();
            orderItems1.setProduct(new Product(request.getProductId()));
            orderItems1.setQuantity(request.getQuantity());
            orderItems.add(orderItems1);
        }
        return orderItems;
    }
}
