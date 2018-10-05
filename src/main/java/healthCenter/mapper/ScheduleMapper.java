package healthCenter.mapper;

import healthCenter.Dto.ScheduleForm;
import healthCenter.entity.Schedule;

/**
 * @author ania
 */
public class ScheduleMapper {

    public static Schedule toEntity(ScheduleForm scheduleForm) {
        return Schedule.builder()
                .date(scheduleForm.getDate())
                .timeFrom(scheduleForm.getTimeFrom())
                .timeTo(scheduleForm.getTimeTo())
                //.office(scheduleForm.getOffice())
                .build();
    }
}
