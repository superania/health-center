package healthCenter.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ania
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Schedule {

    @Id
    @GeneratedValue
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    @ManyToOne
    private Office office;
    @ManyToOne
    private Doctor doctor;

    public static int compareByDateThenHour(Schedule schedule1, Schedule schedule2) {
        if(schedule1.getDate().isEqual(schedule2.getDate())) {
            return schedule1.getTimeFrom().compareTo(schedule2.getTimeFrom());
        } else {
            return schedule1.getDate().compareTo(schedule2.getDate());
        }
    }
}

















