
package store.shop.mte.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.shop.mte.app.model.ProductInOrder;
import store.shop.mte.app.model.ProductInfo;


@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInfo,Long> {

    public void save(ProductInOrder prod);
    
}
