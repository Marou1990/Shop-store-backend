
package store.shop.mte.app.repository;

import java.util.Collection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import store.shop.mte.app.model.User;


@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    User findByEmail(String email);
    Collection<User> findAllByRole(String role);
}
