
package store.shop.mte.app.service;

import java.util.Collection;
import store.shop.mte.app.model.User;


public interface UserService {
    
    User findOne(String email);
    
    Collection<User> findByRole(String role);
    
    User save(User user);
    
    User update(User user);
    
}
