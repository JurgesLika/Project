package Client;

import dto.CategoryRequest;
import dto.ProductRequest;
import entity.Category;
import entity.Product;
import service.CategoryService;
import service.CategoryServiceImpl;
import service.ProductService;
import service.ProductServiceImpl;
import conventer.CategoryConventer;

import java.util.List;
import java.util.Scanner;

public class InventoryManagementSystem //Admini
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ProductRequest product = new ProductRequest();
        ProductServiceImpl productService = new ProductServiceImpl();
        CategoryService categoryService = new CategoryServiceImpl();


        Scanner sc = new Scanner(System.in);
        System.out.println("Inventory Managment Syste");
        System.out.println("1. Add product");
        System.out.println("2, Display all products by ID");
        System.out.println("3, Display all products.");
        System.out.println("4. Add category");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                shto(sc);
                break;
            case 2:
                findById();
            case 3:
                findAll();
            case 4:
                addCategory(scanner, categoryService);

        }
        }



 //Metodat e nertuara.
    public static void findById(){
        Scanner scanner = new Scanner(System.in);
        ProductServiceImpl productService = new ProductServiceImpl();
        System.out.print("Enter product ID to search: ");
        Product product = productService.findById(scanner.nextLong());
        if (product != null) {
            System.out.println("Product found: " + product);
        } else {
            System.out.println("Product not found");
        }

        // Close scanner and sessionFactory
        scanner.close();
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
    public static void findAll(){
        Scanner scanner = new Scanner(System.in);
        ProductServiceImpl productService = new ProductServiceImpl();
        List<Product> products = productService.findAll();
        System.out.println("All Products:");
        for (Product product : products) {
            System.out.println(product);
        }
    }

    private static void addCategory(Scanner scanner, CategoryService categoryService) {
        CategoryRequest categoryRequest = new CategoryRequest();
        System.out.println("Enter category name:");
        categoryRequest.setName(scanner.next());

        Category category = CategoryConventer.convertToCategory(categoryRequest);
        categoryService.saveCategory(category);
        System.out.println("Category added successfully.");
    }
}
