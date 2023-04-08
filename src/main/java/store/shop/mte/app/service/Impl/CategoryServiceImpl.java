package store.shop.mte.app.service.Impl;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import store.shop.mte.app.enums.ResultEnum;
import store.shop.mte.app.exception.MyException;
import store.shop.mte.app.model.ProductCategory;
import store.shop.mte.app.repository.ProductCategoryRepository;
import store.shop.mte.app.service.CategoryService;




@Service
public class CategoryServiceImpl  implements CategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository ;
    
    @Override
    public List<ProductCategory> findAll() {
       return productCategoryRepository.findAllByOrderByCategoryType();
    }

    @Override
    public ProductCategory findByCategoryType(Integer categoryType) {
        ProductCategory res = productCategoryRepository.findByCategoryType(categoryType);
        if(res == null) throw new MyException(ResultEnum.CATEGORY_NOT_FOUND);
        return res;
    }

    @Override
    public List<ProductCategory> findByCategoryTypeIn(List<Integer> categoryTypeList) {
        return productCategoryRepository.findByCategoryTypeInOrderByCategoryTypeAsc(categoryTypeList);
    }

    @Override
    @Transactional
    public ProductCategory save(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }
    
}
