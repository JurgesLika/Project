package Client;

import dto.ProductRequest;
import entity.Product;
import service.ProductService;
import service.ProductServiceImpl;

import java.util.Scanner;

public class InventoryManagementSystem //Admini
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRequest product = new ProductRequest();
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.println("Klikoni 1 per te shtuar te dhena , klikoni 5 per exit" +
                "Kliko 2 per te gjetur me ane te ID");
        int n = scanner.nextInt();
        while (n!=5){
            switch (n){
                case 1:
                        shto(scanner);
                break;
            }
            System.out.println("A doni ta vazhdoni?");
            n= scanner.nextInt();
        }




    }
    public static void shto(Scanner scanner){
        ProductRequest product = new ProductRequest();
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.println("Jepni emrin e produktit.");
        String name = scanner.next();
        System.out.println("Jepni diskription.");
        String description = scanner.next();
        System.out.println("Jepni cmimin.");
        double price = scanner.nextDouble();
        System.out.println("Jepni sasine.");
        Integer quantity = scanner.nextInt();
        System.out.println("Jepni categoriId.");
        Long categoryId = scanner.nextLong();

        //I hedhim ne entity
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setCategoryId(categoryId);
        //i hedhim tek service

        productService.create(product);
    }
}
