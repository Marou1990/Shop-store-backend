package store.shop.mte.app.service;

import java.util.Collection;
import store.shop.mte.app.model.ProductInOrder;
import store.shop.mte.app.model.User;
import store.shop.mte.app.model.cart;


public interface CartService {
  cart getCart(User user);

    void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user);

    void delete(String itemId, User user);

    void checkout(User user);
    
}
