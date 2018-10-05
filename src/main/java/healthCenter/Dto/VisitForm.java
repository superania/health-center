package healthCenter.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author ania
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VisitForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "Date must not be empty")
    private LocalDate date;
    private LocalTime timeFrom;
    private LocalTime timeTo;
    @NotEmpty(message = "That field must not be empty")
    private String doctorAnnotation;
    private Long patientId;



}
