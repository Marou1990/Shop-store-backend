
package store.shop.mte.app.service;

import java.util.List;
import store.shop.mte.app.model.ProductCategory;


public interface CategoryService {
    
   List<ProductCategory> findAll();

    ProductCategory findByCategoryType(Integer categoryType);

    List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList);

    ProductCategory save(ProductCategory productCategory);
    
}
