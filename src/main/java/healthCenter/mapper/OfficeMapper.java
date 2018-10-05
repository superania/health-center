package healthCenter.mapper;

import healthCenter.Dto.NewOfficeDto;
import healthCenter.entity.Office;

/**
 * @author ania
 */
public class OfficeMapper {

    public static Office toEntity(NewOfficeDto officeDto) {
        return Office.builder()
                .number(officeDto.getNumber())
                .name(officeDto.getName())
                .build();
    }
}
