package healthCenter.repository;

import healthCenter.entity.Schedule;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * @author ania
 */
public interface ScheduleRepository extends JpaRepository<Schedule,Long> {

    Schedule findById(Long id);

    List<Schedule> findByDoctor_Id(Long id);

    List<Schedule> findByDate(LocalDate date);
}
