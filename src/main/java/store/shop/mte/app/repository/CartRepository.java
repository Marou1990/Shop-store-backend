
package store.shop.mte.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.shop.mte.app.model.cart;

@Repository
public interface CartRepository extends JpaRepository<cart,Integer>  {
    
}
