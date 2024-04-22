package conventer;

import dto.CategoryRequest;
import entity.Category;

public class CategoryConventer {
    public static Category convertToCategory(CategoryRequest categoryRequest) {
        Category category = new Category();
        category.setName(categoryRequest.getName());
        return category;
    }
}
