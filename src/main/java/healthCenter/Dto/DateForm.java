package healthCenter.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

/**
 * @author ania
 */

@Getter
@Setter
public class DateForm {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
}
