package healthCenter.repository;

import healthCenter.entity.Doctor;
import healthCenter.entity.Office;
import healthCenter.entity.Patient;
import healthCenter.entity.Visit;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ania
 */
public interface VisitRepository extends JpaRepository<Visit,Long> {

   List<Visit> findByPatient(Patient patient);

   List<Visit> findByOffice(Office office);

   List<Visit> findByDoctor_Id(Long id);

   List<Visit> findByOffice_Id(Long id);

   List<Visit> findByDate(LocalDate date);

   List<Visit> findByOfficeAndDate(Office office,LocalDate date);

   Visit findById(Long id);


}
