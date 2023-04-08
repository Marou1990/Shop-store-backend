
package store.shop.mte.app.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import store.shop.mte.app.model.ProductInfo;


public interface ProductService {
    
    ProductInfo findOne(String productid);
    Page<ProductInfo> findUpAll(Pageable pageable);
    Page <ProductInfo> findAll(Pageable pageable);
    Page <ProductInfo> findAllInCategory(Integer categoryType, Pageable pageable);
    void increasestock(String productid,int amount);
    void decreasestock(String productid,int amount);
    ProductInfo offSale(String productid);
    ProductInfo onSale(String productid);
    ProductInfo update(ProductInfo productInfo);
    ProductInfo save(ProductInfo productInfo);
    void delete(String productid);
    
    
}
