package healthCenter.repository;

import healthCenter.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author ania
 */
public interface PatientRepository extends JpaRepository<Patient,Long> {

    List<Patient> findByNameAndSurname(String name, String surname);

    Patient findByIdNumber(String idNumber);

    Patient findById(Long id);

    Patient findByLogin(String login);
}
