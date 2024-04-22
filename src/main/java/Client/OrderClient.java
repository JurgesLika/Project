package Client;

import dto.OrderItimesRequest;

import dto.OrederRequest;
import entity.PaymentStatusEnum;
import service.OrderService;
import service.OrderServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class OrderClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome");
        System.out.println("Na ljepni detajet per krijimin e order");
        System.out.println("Ju lutem fusni client id tuaj");
        Long clientId = sc.nextLong();
        System.out.println("Ju lutem fusni payemt status");
        String payementStatus = sc.next();
        List<OrderItimesRequest> orderItemsRequestList = new ArrayList<>();
        int c;
        do {
            System.out.println("Ju lutem fusni product ID, fusni product id = 300 kur ");
            Long productId = sc.nextLong();
            System.out.println("Ju lutem fusni sasine per kte product");
            Integer quantity = sc.nextInt();
            OrderItimesRequest orderItemsRequest;
            orderItemsRequest = new OrderItimesRequest(productId, quantity);
            orderItemsRequestList.add(orderItemsRequest);
            System.out.println("Ju lutem shtypni 1 per te vazhduar te shtoni produkte" +
                    " dhe 0 nese lista e produkteve eshte plotesuar ");
            c = sc.nextInt();
        } while (c != 0);
        OrederRequest orderRequest = new OrederRequest();
        orderRequest.setClientId(clientId);
        orderRequest.setOrderItems(orderItemsRequestList);
        orderRequest.setPeymentStatus(PaymentStatusEnum.valueOf(payementStatus));
        OrderService orderService = new OrderServiceImpl();
        orderService.create(orderRequest);
    }
}