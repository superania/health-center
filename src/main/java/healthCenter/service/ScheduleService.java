package healthCenter.service;

import healthCenter.entity.Schedule;
import healthCenter.repository.ScheduleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author ania
 */
@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ScheduleService {

    private ScheduleRepository scheduleRepository;

    public void saveSchedule(Schedule schedule) {
        scheduleRepository.save(schedule);
    }

    public Schedule findById(Long id) {
        return scheduleRepository.findById(id);
    }

    public List<Schedule> findByDoctorId(Long id) {
        return scheduleRepository.findByDoctor_Id(id)
                .stream()
                .filter(schedule -> !schedule.getDate().isBefore(LocalDate.now()))
                .sorted(Schedule::compareByDateThenHour)
                .collect(Collectors.toList());
    }

    public List<Schedule> findByDate(LocalDate date) {
        return scheduleRepository.findByDate(date);
    }

    public void deleteSchedule(Long id) {
        scheduleRepository.delete(id);
    }
}
