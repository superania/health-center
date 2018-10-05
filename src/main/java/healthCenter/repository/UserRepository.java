package healthCenter.repository;

import healthCenter.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ania
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByLogin(String email);
}
