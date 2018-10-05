package healthCenter.repository;

import healthCenter.entity.Doctor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ania
 */
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Long> {

    Doctor findById(Long id);

    @Query("select d from Doctor d join d.specializations s where s.name = :name")
    List<Doctor> findBySpecialization(@Param("name") String name);

    List<Doctor> findByNameAndSurname(String name,String surname);

    Doctor findByLogin(String login);
}
