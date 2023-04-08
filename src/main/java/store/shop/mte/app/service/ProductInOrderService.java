package store.shop.mte.app.service;

import store.shop.mte.app.model.ProductInOrder;
import store.shop.mte.app.model.User;



public interface ProductInOrderService {
    
    void update(String itemId, Integer quantity, User user);
    ProductInOrder findOne(String itemId, User user);
    
}
