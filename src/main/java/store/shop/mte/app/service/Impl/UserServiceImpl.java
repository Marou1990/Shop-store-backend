package store.shop.mte.app.service.Impl;

import java.util.Collection;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import store.shop.mte.app.enums.ResultEnum;
import store.shop.mte.app.exception.MyException;
import store.shop.mte.app.model.User;
import store.shop.mte.app.model.cart;
import store.shop.mte.app.repository.CartRepository;
import store.shop.mte.app.repository.UserRepository;
import store.shop.mte.app.service.UserService;


@Service
@DependsOn("passwordEncoder")
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder ;
    @Autowired
    UserRepository userRepository ;
    @Autowired
    CartRepository cartRepository ;
    
    @Override
    public User findOne(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Collection<User> findByRole(String role) {
        return userRepository.findAllByRole(role);
    }

    @Override
    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try{
        User saveduser = userRepository.save(user);
        
        // initial Cart
            cart savedCart = cartRepository.save(new cart(saveduser));
            saveduser.setCart(savedCart);
            return userRepository.save(saveduser);
            
        }catch(Exception e){
        throw new MyException(ResultEnum.VALID_ERROR);
        }
    }

    @Override
    @Transactional
    public User update(User user) {
       User olduser = userRepository.findByEmail(user.getEmail());
       olduser.setPassword(passwordEncoder.encode(user.getPassword()));
       olduser.setAddress(user.getAddress());
       olduser.setPhone(user.getPhone());
       olduser.setName(user.getPhone());
       return userRepository.save(olduser);
    }
    
}
