package healthCenter.repository;

import healthCenter.entity.Specialization;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author ania
 */
public interface SpecializationRepository extends JpaRepository<Specialization,Long> {

    Specialization findByName(String name);

    Specialization findById(Long id);



}
