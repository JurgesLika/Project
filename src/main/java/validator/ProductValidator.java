package validator;

import dto.ProductRequest;

public class ProductValidator {
    public static void validateProduct(ProductRequest request){
        if(request.getName().isBlank()){
            throw new IllegalArgumentException("Ju lutem emri i produktit" +
                    " eshte require.");
        }
        if(request.getPrice()<=0){
            throw new IllegalArgumentException("Ju lutem cmimi duhet te jete" +
                    " me i madh se 0.");
        }
    }
}
