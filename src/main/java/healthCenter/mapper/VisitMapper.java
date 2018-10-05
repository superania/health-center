package healthCenter.mapper;

import healthCenter.Dto.VisitForm;
import healthCenter.entity.Visit;

/**
 * @author ania
 */
public class VisitMapper {

    public static Visit visitFormToEntity(VisitForm visitForm) {
        return Visit.builder()
                .date(visitForm.getDate())
                .timeFrom(visitForm.getTimeFrom())
                .timeTo(visitForm.getTimeTo())
                .doctorAnnotation(visitForm.getDoctorAnnotation())
                .build();
    }

}
