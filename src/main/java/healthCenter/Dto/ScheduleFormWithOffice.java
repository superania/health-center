package healthCenter.Dto;

import healthCenter.entity.Office;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author ania
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleFormWithOffice {

    private Long scheduleId;
    private Long officeId;
    private ScheduleForm scheduleForm;
}
