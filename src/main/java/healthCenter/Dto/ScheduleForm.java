package healthCenter.Dto;

import healthCenter.entity.Doctor;
import healthCenter.entity.Office;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
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
public class ScheduleForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Future(message = "Date must be future")
    @NotNull(message = "Date must not be empty")
    private LocalDate date;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    private Long officeId;


}
