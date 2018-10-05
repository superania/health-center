package healthCenter.repository;

import healthCenter.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author ania
 */
@Repository
public interface UserRoleRepository extends JpaRepository<UserRole,Long> {

    UserRole findByRole(String role);



}
