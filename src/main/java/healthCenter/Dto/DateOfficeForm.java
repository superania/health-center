package healthCenter.Dto;

import healthCenter.entity.Office;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

/**
 * @author ania
 */
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DateOfficeForm {

    @NotNull(message = "Date must not be empty")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private Long officeId;

}
