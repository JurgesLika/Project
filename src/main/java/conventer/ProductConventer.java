package conventer;

import dto.ProductRequest;
import entity.Product;

public class ProductConventer {
    public static Product convertToEntity(ProductRequest request){
        Product product = new Product();
        product.setName(request.getName());
        product.setDescription(request.getDescription());
        product.setQuantity(request.getQuantity());
        product.setPrice(request.getPrice());
        return product;
    }
}
