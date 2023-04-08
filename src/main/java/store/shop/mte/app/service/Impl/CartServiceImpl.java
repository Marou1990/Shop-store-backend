package store.shop.mte.app.service.Impl;


import store.shop.mte.app.model.ProductInOrder;
import store.shop.mte.app.model.User;
import store.shop.mte.app.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import lombok.var;
import org.springframework.stereotype.Service;
import store.shop.mte.app.enums.ResultEnum;
import store.shop.mte.app.exception.MyException;
import store.shop.mte.app.model.OrderMain;
import store.shop.mte.app.model.cart;
import store.shop.mte.app.repository.CartRepository;
import store.shop.mte.app.repository.OrderRepository;
import store.shop.mte.app.repository.ProductInOrderRepository;
import store.shop.mte.app.repository.UserRepository;
import store.shop.mte.app.service.ProductService;
import store.shop.mte.app.service.UserService;


@Service
public class CartServiceImpl implements CartService {

    @Autowired
    ProductService productService;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;

    @Autowired
    ProductInOrderRepository productInOrderRepository;
    @Autowired
    CartRepository cartRepository;
    @Autowired
    UserService userService;

    @Override
    public cart getCart(User user) {
        return user.getCart();
    }

    @Override
    @Transactional
    public void mergeLocalCart(Collection<ProductInOrder> productInOrders, User user) {
        cart finalCart = user.getCart();
        productInOrders.forEach(productInOrder -> {
            Set<ProductInOrder> set = finalCart.getProducts();
            Optional<ProductInOrder> old = set.stream().filter(e -> e.getProductid().equals(productInOrder.getProductid())).findFirst();
            ProductInOrder prod;
            if (old.isPresent()) {
                prod = old.get();
                prod.setCount(productInOrder.getCount() + prod.getCount());
            } else {
                prod = productInOrder;
                prod.setCart(finalCart);
                finalCart.getProducts().add(prod);
            }
            productInOrderRepository.save(prod);
        });
        cartRepository.save(finalCart);

    }

    @Override
    @Transactional
    public void delete(String itemId, User user) {
        if(itemId.equals("") || user == null) {
            throw new MyException(ResultEnum.ORDER_STATUS_ERROR);
        }

        var op = user.getCart().getProducts().stream().filter(e -> itemId.equals(e.getProductid())).findFirst();
        op.ifPresent(productInOrder -> {
            productInOrder.setCart(null);
            productInOrderRepository.deleteById(productInOrder.getId());
        });
    }

    @Override
    @Transactional
    public void checkout(User user) {
        // Creat an order
        OrderMain order = new OrderMain(user);
        orderRepository.save(order);

        // clear cart's foreign key & set order's foreign key& decrease stock
        user.getCart().getProducts().forEach(productInOrder -> {
            productInOrder.setCart(null);
            productInOrder.setOrderMain(order);
            productService.decreasestock(productInOrder.getProductid(), productInOrder.getCount());
            productInOrderRepository.save(productInOrder);
        });

    }
    
}
