package healthCenter.Dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ania
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AppointmentForm {

    private Long doctorId;
    private LocalDate date;
    private LocalTime time;




}
