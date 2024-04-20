package conventer;

import dto.ProductRequest;
import entity.Category;
import entity.Product;

public class ProductConventer {
    public static Product convertToEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        product.setCategory(new Category(request.getCategoryId()));

        return product;
    }
}
