package healthCenter.mapper;

import healthCenter.Dto.SpecializationForm;
import healthCenter.entity.Specialization;

/**
 * @author ania
 */
public class SpecializationMapper {

    public static Specialization toEntity(SpecializationForm specializationForm) {
        return Specialization.builder()
                .name(specializationForm.getName().toUpperCase())
                .build();
    }
}
