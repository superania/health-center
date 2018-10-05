package healthCenter.repository;

import healthCenter.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ania
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Long> {

    Admin findByLogin(String login);
}
